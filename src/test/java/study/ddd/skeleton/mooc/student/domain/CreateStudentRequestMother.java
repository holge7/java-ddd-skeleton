package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.mooc.student.application.create.CreateStudentRequest;

public class CreateStudentRequestMother {

    public static CreateStudentRequest create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        return new CreateStudentRequest(id.value(), name.value(), surname.value(), email.value());
    }

    public static CreateStudentRequest random() {
        return create(
                StudentIdMother.random(),
                StudentNameMother.random(),
                StudentSurnameMother.random(),
                StudentEmailMother.random()
        );
    }

}