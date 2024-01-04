package study.ddd.skeleton.shared.infrastructure.bus.event;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.Utils;
import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@Service
public class DomainEventJsonDeserializer {
    private final DomainEventsInformation information;

    public DomainEventJsonDeserializer(DomainEventsInformation information) {
        this.information = information;
    }

    public DomainEvent deserialize(String body) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HashMap<String, Serializable> eventData        = Utils.jsonDecode(body);
        HashMap<String, Serializable> data             = (HashMap<String, Serializable>) eventData.get("data");
        HashMap<String, Serializable> attributes       = (HashMap<String, Serializable>) data.get("attributes");
        Class<? extends DomainEvent>  domainEventClass = information.forName((String) data.get("type"));

        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();

        Method fromPrimitivesMethod = domainEventClass.getMethod(
                "fromPrimitives",
                String.class,
                HashMap.class,
                String.class,
                String.class
        );

        Object domainEvent = fromPrimitivesMethod.invoke(
                nullInstance,
                (String) attributes.get("id"),
                attributes,
                (String) data.get("id"),
                (String) data.get("occurred_on")
        );

        return (DomainEvent) domainEvent;
    }
}