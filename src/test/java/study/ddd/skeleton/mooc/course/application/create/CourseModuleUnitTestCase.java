package study.ddd.skeleton.mooc.course.application.create;

import org.junit.jupiter.api.BeforeEach;
import study.ddd.skeleton.mooc.course.domain.Course;
import study.ddd.skeleton.mooc.course.domain.CourseRepository;
import study.ddd.skeleton.shared.domain.bus.event.EventBus;
import study.ddd.skeleton.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class CourseModuleUnitTestCase extends UnitTestCase {
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(CourseRepository.class);
    }

    protected void shouldHaveSaved(Course course) {
        verify(repository, atLeastOnce()).save(course);
    }

}