package study.ddd.skeleton.mooc.course.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.course.domain.*;
import study.ddd.skeleton.shared.domain.course.CourseCreatedDomainEvent;

final class CourseCreatorCommandHandlerTest extends CourseModuleUnitTestCase {
    private CreateCourseCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateCourseCommandHandler(new CourseCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_course() {
        CreateCourseCommand command = CreateCourseCommandMother.random();

        Course course = CreateCourseMother.fromRequest(command);
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

        handler.handle(command);

        shouldHaveSaved(course);
        shouldHavePublished(domainEvent);
    }

}