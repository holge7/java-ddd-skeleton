package study.ddd.skeleton.shared.infrastructure.bus.event.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;
import study.ddd.skeleton.shared.domain.bus.event.EventBus;
import study.ddd.skeleton.shared.infrastructure.bus.event.postgresql.PostgreSqlEventBus;

import java.util.Collections;
import java.util.List;

@Primary
@Service
public class RabbitMqEventBus implements EventBus {
    Logger logger = LoggerFactory.getLogger(RabbitMqEventBus.class);
    private final RabbitMqPublisher publisher;
    private final PostgreSqlEventBus failoverPublisher;
    private final String exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher, PostgreSqlEventBus failoverPublisher) {
        this.publisher = publisher;
        this.failoverPublisher = failoverPublisher;
        this.exchangeName = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            logger.error(error.toString());
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }

}