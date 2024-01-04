package study.ddd.skeleton.mooc.student.application;

import study.ddd.skeleton.mooc.student.application.create.CreateStudentCommand;
import study.ddd.skeleton.mooc.student.domain.*;

public class CreateStudentCommandMother {

    public static CreateStudentCommand create(StudentId id, StudentEmail email, StudentName name, StudentSurname surname) {
        return new CreateStudentCommand(id.value(), email.value(), name.value(), surname.value());
    }

    public static CreateStudentCommand random() {
        return create(StudentIdMother.random(), StudentEmailMother.random(), StudentNameMother.random(), StudentSurnameMother.random());
    }

}