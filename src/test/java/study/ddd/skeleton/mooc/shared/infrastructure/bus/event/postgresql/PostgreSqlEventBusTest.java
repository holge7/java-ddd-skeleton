package study.ddd.skeleton.mooc.shared.infrastructure.bus.event.postgresql;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import study.ddd.skeleton.mooc.MoocContextInfrastructureTestCase;
import study.ddd.skeleton.mooc.course.domain.CourseCreatedDomainEventMother;
import study.ddd.skeleton.shared.domain.course.CourseCreatedDomainEvent;
import study.ddd.skeleton.shared.infrastructure.bus.event.postgresql.PostgreSqlDomainEventConsumer;
import study.ddd.skeleton.shared.infrastructure.bus.event.postgresql.PostgreSqlEventBus;

import java.util.Collections;

@Transactional
public class PostgreSqlEventBusTest extends MoocContextInfrastructureTestCase {
    @Autowired
    private PostgreSqlEventBus eventBus;
    @Autowired
    private PostgreSqlDomainEventConsumer consumer;

    @Test
    void publis_and_consume_domain_events_from_postgresql() throws InterruptedException {
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        Thread consumerProcess = new Thread(() -> consumer.consume());
        consumerProcess.start();

        Thread.sleep(100);

        consumer.stop();
    }

}