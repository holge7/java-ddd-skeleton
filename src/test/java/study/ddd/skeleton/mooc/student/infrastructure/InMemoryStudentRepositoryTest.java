package study.ddd.skeleton.mooc.student.infrastructure;

import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.student.StudentModuleInfrastructureTestCase;
import study.ddd.skeleton.mooc.student.domain.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStudentRepositoryTest extends StudentModuleInfrastructureTestCase {

    @Test
    void save_valid_student() {
        inMemoryCourseRepository.save(CreateStudentMother.random());
    }

    @Test
    void search_an_existing_student() {
        Student student = CreateStudentMother.random();
        inMemoryCourseRepository.save(student);

        assertEquals(inMemoryCourseRepository.search(student.id()), Optional.of(student));
    }

    @Test
    void not_find_a_non_existing_student() {
        assertFalse(inMemoryCourseRepository.search(StudentIdMother.random()).isPresent());
    }
}