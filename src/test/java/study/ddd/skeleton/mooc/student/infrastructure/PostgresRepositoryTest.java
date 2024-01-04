package study.ddd.skeleton.mooc.student.infrastructure;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.student.StudentModuleInfrastructureTestCase;
import study.ddd.skeleton.mooc.student.domain.CreateStudentMother;
import study.ddd.skeleton.mooc.student.domain.Student;
import study.ddd.skeleton.mooc.student.domain.StudentIdMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class PostgresRepositoryTest extends StudentModuleInfrastructureTestCase {

    @Test
    void save_valid_student() {
        postgresStudentRepository.save(CreateStudentMother.random());
    }

    @Test
    void search_an_existing_student() {
        Student student = CreateStudentMother.random();
        postgresStudentRepository.save(student);

        assertEquals(postgresStudentRepository.search(student.id()), Optional.of(student));
    }

    @Test
    void not_find_a_non_existing_student() {
        assertFalse(postgresStudentRepository.search(StudentIdMother.random()).isPresent());
    }
}