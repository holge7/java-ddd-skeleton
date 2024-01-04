package study.ddd.skeleton.shared.infrastructure.bus.event.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.Utils;
import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;
import study.ddd.skeleton.shared.infrastructure.bus.event.DomainEventJsonDeserializer;
import study.ddd.skeleton.shared.infrastructure.bus.event.DomainEventSubscribersInformation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Service
public class RabbitMqDomainEventsConsumer {
    private final String CONSUMER_NAME = "domain_events_consumer";
    private final int MAX_RETRIES = 2;
    private final DomainEventJsonDeserializer deserializer;
    private final ApplicationContext context;
    private final RabbitMqPublisher publisher;
    private final HashMap<String, Object> domainEventSubscribers = new HashMap<>();
    RabbitListenerEndpointRegistry registry;
    private DomainEventSubscribersInformation information;

    public RabbitMqDomainEventsConsumer(
            DomainEventJsonDeserializer deserializer,
            ApplicationContext context,
            RabbitMqPublisher publisher,
            RabbitListenerEndpointRegistry registry,
            DomainEventSubscribersInformation information
    ) {
        this.deserializer = deserializer;
        this.context = context;
        this.publisher = publisher;
        this.registry = registry;
        this.information = information;
    }

    // Método para iniciar la escucha de eventos
    public void consume() {
        // Obtener el contenedor del escucha de mensajes
        AbstractMessageListenerContainer container = (AbstractMessageListenerContainer) registry.getListenerContainer(
                CONSUMER_NAME
        );

        // Agregar nombres de colas al contenedor
        container.addQueueNames(information.rabbitMqFormattedNames());

        // Iniciar el contenedor
        container.start();
    }

    // Método de escucha de RabbitMQ
    @RabbitListener(id = CONSUMER_NAME, autoStartup = "false")
    public void consumer(Message message) throws Exception {
        // Obtener el mensaje serializado
        String serializedMessage = new String(message.getBody());

        // Deserializar el evento de dominio
        DomainEvent domainEvent = deserializer.deserialize(serializedMessage);

        // Obtener la cola de destino del mensaje
        String queue = message.getMessageProperties().getConsumerQueue();

        // Obtener o crear el suscriptor correspondiente a la cola
        Object subscriber = domainEventSubscribers.containsKey(queue)
                ? domainEventSubscribers.get(queue)
                : subscriberFor(queue);

        // Obtener el método 'on' del suscriptor para el tipo de evento
        Method subscriberOnMethod = subscriber.getClass().getMethod("on", domainEvent.getClass());

        try {
            // Invocar el método 'on' del suscriptor
            subscriberOnMethod.invoke(subscriber, domainEvent);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
            // Manejar errores de invocación del método
            throw new Exception(String.format(
                    "The subscriber <%s> should implement a method `on` listening the domain event <%s>",
                    queue,
                    domainEvent.eventName()
            ));
        } catch (Exception error) {
            // Manejar otros errores durante la consumición del mensaje
            handleConsumptionError(message, queue);
        }
    }

    public void withSubscribersInformation(DomainEventSubscribersInformation information) {
        this.information = information;
    }

    private void handleConsumptionError(Message message, String queue) {
        if (hasBeenRedeliveredTooMuch(message)) {
            sendToDeadLetter(message, queue);
        } else {
            sendToRetry(message, queue);
        }
    }

    private void sendToRetry(Message message, String queue) {
        sendMessageTo(RabbitMqExchangeNameFormatter.retry("domain_events"), message, queue);
    }

    private void sendToDeadLetter(Message message, String queue) {
        sendMessageTo(RabbitMqExchangeNameFormatter.deadLetter("domain_events"), message, queue);
    }

    private void sendMessageTo(String exchange, Message message, String queue) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();

        headers.put("redelivery_count", (int) headers.getOrDefault("redelivery_count", 0) + 1);

        MessageBuilder.fromMessage(message).andProperties(
                MessagePropertiesBuilder.newInstance()
                        .setContentEncoding("utf-8")
                        .setContentType("application/json")
                        .copyHeaders(headers)
                        .build());

        publisher.publish(message, exchange, queue);
    }

    private boolean hasBeenRedeliveredTooMuch(Message message) {
        return (int) message.getMessageProperties().getHeaders().getOrDefault("redelivery_count", 0) >= MAX_RETRIES;
    }

    private Object subscriberFor(String queue) throws Exception {
        String[] queueParts     = queue.split("\\.");
        String   subscriberName = Utils.toCamelFirstLower(queueParts[queueParts.length - 1]);

        try {
            Object subscriber = context.getBean(subscriberName);
            domainEventSubscribers.put(queue, subscriber);

            return subscriber;
        } catch (Exception e) {
            throw new Exception(String.format("There are not registered subscribers for <%s> queue", queue));
        }
    }

}