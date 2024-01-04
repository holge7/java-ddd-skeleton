package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.mooc.student.application.create.CreateStudentCommand;
import study.ddd.skeleton.shared.domain.student.StudentCreatedDomainEvent;

public class StudentCreatedDomainEventMother {

    public static StudentCreatedDomainEvent create(StudentId id, StudentEmail email, StudentName name, StudentSurname surname) {
        return new StudentCreatedDomainEvent(id.value(), email.value(), name.value(), surname.value());
    }

    public static StudentCreatedDomainEvent fromStudent(Student student) {
        return create(student.id(), student.email(), student.name(), student.surname());
    }

    public static StudentCreatedDomainEvent random() {
        return create(StudentIdMother.random(), StudentEmailMother.random(), StudentNameMother.random(), StudentSurnameMother.random());
    }

}