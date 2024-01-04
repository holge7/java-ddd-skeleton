package study.ddd.skeleton.shared.domain.bus.event;

import study.ddd.skeleton.shared.domain.Utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public abstract class DomainEvent {

    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
         this.aggregateId = aggregateId;
         this.eventId = UUID.randomUUID().toString();
         this.occurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregatedId, String eventId, String occurredOn) {
        this.aggregateId = aggregatedId;
        this.eventId = eventId;
        this.occurredOn = occurredOn;
    }

    protected DomainEvent() {}

    public abstract String eventName();

    public abstract HashMap<String, Serializable> toPrimitives();

    public abstract DomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    );

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }

    @Override
    public String toString() {
        return "DomainEvent{" +
                "aggregateId='" + aggregateId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", occurredOn='" + occurredOn + '\'' +
                '}';
    }
}