package study.ddd.skeleton.mooc.courses_counter.application.increment;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.course.domain.CourseCreatedDomainEventMother;
import study.ddd.skeleton.mooc.course.domain.CourseId;
import study.ddd.skeleton.mooc.course.domain.CourseIdMother;
import study.ddd.skeleton.mooc.courses_counter.CoursesCounterModuleUnitTestCase;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounter;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounterMother;
import study.ddd.skeleton.shared.domain.course.CourseCreatedDomainEvent;

final class IncrementCoursesCounterOnCourseCreatedTest extends CoursesCounterModuleUnitTestCase {
    IncrementCoursesCounterOnCourseCreated subscriber;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subscriber = new IncrementCoursesCounterOnCourseCreated(
                new CoursesCounterIncrementer(repository, uuidGenerator)
        );
    }

    @Test
    void it_should_initialize_a_new_counter() {
        CourseCreatedDomainEvent event = CourseCreatedDomainEventMother.random();

        CourseId courseId = CourseIdMother.create(event.aggregateId());
        CoursesCounter newCounter = CoursesCounterMother.withOne(courseId);

        shouldSearch();
        shouldGenerateUuid(newCounter.id().value());

        subscriber.on(event);

        shouldHaveSaved(newCounter);
    }

    @Test
    void it_should_increment_an_existing_counter() {
        CourseCreatedDomainEvent event = CourseCreatedDomainEventMother.random();

        CourseId courseId = CourseIdMother.create(event.aggregateId());
        CoursesCounter existingCounter = CoursesCounterMother.random();
        CoursesCounter incrementedCounter = CoursesCounterMother.incrementing(existingCounter, courseId);

        shouldSearch(existingCounter);

        subscriber.on(event);

        shouldHaveSaved(incrementedCounter);
    }

    @Test
    void it_should_not_increment_an_already_incremented_course() {
        CourseCreatedDomainEvent event = CourseCreatedDomainEventMother.random();

        CourseId courseId = CourseIdMother.create(event.aggregateId());
        CoursesCounter existingCounter = CoursesCounterMother.withOne(courseId);

        shouldSearch(existingCounter);

        subscriber.on(event);
    }

}