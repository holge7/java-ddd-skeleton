package study.ddd.skeleton.mooc.courses_counter;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounter;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounterRepository;
import study.ddd.skeleton.shared.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class CoursesCounterModuleUnitTestCase extends UnitTestCase {

    protected CoursesCounterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(CoursesCounterRepository.class);
    }

    public void shouldSearch(CoursesCounter course) {
        Mockito.when(repository.search()).thenReturn(Optional.of(course));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(CoursesCounter course) {
        verify(repository, atLeastOnce()).save(course);
    }

}