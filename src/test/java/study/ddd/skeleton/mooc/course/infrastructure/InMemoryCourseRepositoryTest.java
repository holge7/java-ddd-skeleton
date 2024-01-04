package study.ddd.skeleton.mooc.course.infrastructure;

import org.junit.jupiter.api.Test;
import study.ddd.skeleton.mooc.course.CourseModuleInfrastructureTestCase;
import study.ddd.skeleton.mooc.course.domain.*;
import study.ddd.skeleton.mooc.course.infrastructure.persistence.InMemoryCourseRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest extends CourseModuleInfrastructureTestCase {

    @Test
    void save_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        repository.save(CreateCourseMother.random());
    }

    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Course course = CreateCourseMother.random();
        repository.save(course);

        assertEquals(Optional.of(course), repository.search(course.getId()));
    }

    @Test
    void not_find_a_non_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        assertFalse(repository.search(CourseIdMother.random()).isPresent());
    }

}