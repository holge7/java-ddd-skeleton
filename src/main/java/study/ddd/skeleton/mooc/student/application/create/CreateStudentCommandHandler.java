package study.ddd.skeleton.mooc.student.application.create;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.student.domain.StudentEmail;
import study.ddd.skeleton.mooc.student.domain.StudentId;
import study.ddd.skeleton.mooc.student.domain.StudentName;
import study.ddd.skeleton.mooc.student.domain.StudentSurname;
import study.ddd.skeleton.shared.domain.bus.command.CommandHandler;

@Service
public class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand> {

    private final StudentCreator creator;

    public CreateStudentCommandHandler(StudentCreator creator) {
        this.creator = creator;
    }


    @Override
    public void handle(CreateStudentCommand command) {
        StudentId id = new StudentId(command.id());
        StudentEmail email = new StudentEmail(command.email());
        StudentName name = new StudentName(command.name());
        StudentSurname surname = new StudentSurname(command.surname());

        creator.create(id, email, name, surname);
    }

}