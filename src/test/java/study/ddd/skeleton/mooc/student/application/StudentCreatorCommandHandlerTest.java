package study.ddd.skeleton.mooc.student.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.student.application.create.CreateStudentCommand;
import study.ddd.skeleton.mooc.student.application.create.CreateStudentCommandHandler;
import study.ddd.skeleton.mooc.student.application.create.StudentCreator;
import study.ddd.skeleton.mooc.student.domain.CreateStudentMother;
import study.ddd.skeleton.mooc.student.domain.Student;
import study.ddd.skeleton.mooc.student.domain.StudentCreatedDomainEventMother;
import study.ddd.skeleton.shared.domain.student.StudentCreatedDomainEvent;

final class StudentCreatorCommandHandlerTest extends StudentModuleUnitTestCase {
    private CreateStudentCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateStudentCommandHandler(new StudentCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_student() {
        CreateStudentCommand command = CreateStudentCommandMother.random();

        Student student = CreateStudentMother.fromCommand(command);
        StudentCreatedDomainEvent domainEvent = StudentCreatedDomainEventMother.fromStudent(student);

        handler.handle(command);

        shouldHaveSaved(student);
        shouldHavePublished(domainEvent);
    }

}