package study.ddd.skeleton.mooc.student.application.create;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.student.domain.*;
import study.ddd.skeleton.shared.domain.bus.event.EventBus;

@Service
public final class StudentCreator {

    private final StudentRepository repository;
    private final EventBus eventBus;

    public StudentCreator(StudentRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(StudentId id, StudentEmail email, StudentName name, StudentSurname surname) {
        Student student = Student.create(id, email, name, surname);

        repository.save(student);
        eventBus.publish(student.pullDomainEvents());
    }

}
