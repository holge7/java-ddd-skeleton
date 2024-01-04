package study.ddd.skeleton.mooc.courses_counter.application.increment;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.course.domain.CourseId;
import study.ddd.skeleton.shared.domain.bus.event.DomainEventSubscriber;
import study.ddd.skeleton.shared.domain.course.CourseCreatedDomainEvent;

@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class IncrementCoursesCounterOnCourseCreated {
    private final CoursesCounterIncrementer incrementer;

    public IncrementCoursesCounterOnCourseCreated(CoursesCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(CourseCreatedDomainEvent event) {
        CourseId courseId = new CourseId(event.aggregateId());

        incrementer.increment(courseId);
    }

}