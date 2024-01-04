package study.ddd.skeleton.shared.infrastructure.bus.event.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;
import study.ddd.skeleton.shared.domain.bus.event.EventBus;

import java.util.List;

@Service
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent  event) {
        this.publisher.publishEvent(event);
    }
}