package study.ddd.skeleton.retention.notifications.application.send_welcome_user_email;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.event.DomainEventSubscriber;
import study.ddd.skeleton.shared.domain.student.StudentCreatedDomainEvent;

@Service
@DomainEventSubscriber({StudentCreatedDomainEvent.class})
public class StudentTest {

    @EventListener
    public void on(StudentCreatedDomainEvent event) {
        System.out.println(event);
        System.out.println("===================");
        System.out.println("SENDING EMAIL TO NEW STUDENT!!!");
        System.out.println("===================");
    }

}