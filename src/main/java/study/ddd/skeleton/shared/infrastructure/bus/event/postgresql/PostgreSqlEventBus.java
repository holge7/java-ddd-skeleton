package study.ddd.skeleton.shared.infrastructure.bus.event.postgresql;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.ddd.skeleton.shared.domain.Utils;
import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;
import study.ddd.skeleton.shared.domain.bus.event.EventBus;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class PostgreSqlEventBus implements EventBus {
    private final SessionFactory sessionFactory;

    public PostgreSqlEventBus(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        String id = domainEvent.eventId();
        String aggregateId = domainEvent.aggregateId();
        String name = domainEvent.eventName();
        HashMap<String, Serializable> body = domainEvent.toPrimitives();
        LocalDate occurredOnDate = LocalDate.parse(domainEvent.occurredOn(), DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDateTime occurredOn = occurredOnDate.atStartOfDay();

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
                "INSERT INTO domain_events (id,  aggregate_id, name,  body,  occurred_on) VALUES (:id, :aggregateId, :name, :body, :occurredOn);"
        );

        query.setParameter("id", id)
                .setParameter("aggregateId", aggregateId)
                .setParameter("name", name)
                .setParameter("body", Utils.jsonEncode(body))
                .setParameter("occurredOn", Timestamp.valueOf(occurredOn));

        query.executeUpdate();
    }

}