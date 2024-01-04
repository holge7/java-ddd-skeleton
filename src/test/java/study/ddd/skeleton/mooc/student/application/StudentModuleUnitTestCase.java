package study.ddd.skeleton.mooc.student.application;

import org.junit.jupiter.api.BeforeEach;
import study.ddd.skeleton.mooc.student.domain.Student;
import study.ddd.skeleton.mooc.student.domain.StudentRepository;
import study.ddd.skeleton.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class StudentModuleUnitTestCase extends UnitTestCase {

    protected StudentRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(StudentRepository.class);
    }

    protected void shouldHaveSaved(Student student) {
        verify(repository, atLeastOnce()).save(student);
    }

}
