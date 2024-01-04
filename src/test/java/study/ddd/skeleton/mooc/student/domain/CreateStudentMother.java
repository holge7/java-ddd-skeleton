package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.mooc.course.domain.CourseIdMother;
import study.ddd.skeleton.mooc.student.application.create.CreateStudentCommand;
import study.ddd.skeleton.mooc.student.application.create.CreateStudentRequest;

public class CreateStudentMother {

    public static Student create(
            StudentId id,
            StudentName name,
            StudentSurname surname,
            StudentEmail email) {
        return new Student(id, email, name, surname);
    }

    public static Student fromCommand(CreateStudentCommand command) {
        return create(
                StudentIdMother.create(command.id()),
                StudentNameMother.create(command.name()),
                StudentSurnameMother.create(command.surname()),
                StudentEmailMother.create(command.email())
        );
    }

    public static Student random() {
        return create(
                StudentIdMother.random(),
                StudentNameMother.random(),
                StudentSurnameMother.random(),
                StudentEmailMother.random()
        );
    }

}
