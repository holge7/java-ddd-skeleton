package study.ddd.skeleton.mooc.course.application.create;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.course.domain.*;
import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;
import study.ddd.skeleton.shared.domain.bus.event.EventBus;

import java.util.List;

@Service
public final class CourseCreator {
    private final CourseRepository repository;
    private final EventBus eventBus;

    public CourseCreator(CourseRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(CourseId id, CourseName name, CourseDuration duration) {
        Course course = Course.create(id, name, duration);

        repository.save(course);
        eventBus.publish(course.pullDomainEvents());
    }

}