package study.ddd.skeleton.mooc.course.infrastructure;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.course.CourseModuleInfrastructureTestCase;
import study.ddd.skeleton.mooc.course.domain.Course;
import study.ddd.skeleton.mooc.course.domain.CourseIdMother;
import study.ddd.skeleton.mooc.course.domain.CreateCourseMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional // Con esta anotación estamos especificando que cuando se realizen los tests se haga un rollback de tdo lo que se haya creado
public class PostgresRepositoryTest extends CourseModuleInfrastructureTestCase {

    @Test
    void save_valid_course() {
        postgresCourseRepository.save(CreateCourseMother.random());
    }

    @Test
    void search_an_existing_course() {
        Course course = CreateCourseMother.random();
        postgresCourseRepository.save(course);

        assertEquals(Optional.of(course), postgresCourseRepository.search(course.getId()));
    }

    @Test
    void not_find_a_non_existing_course() {
        assertFalse(postgresCourseRepository.search(CourseIdMother.random()).isPresent());
    }


}
