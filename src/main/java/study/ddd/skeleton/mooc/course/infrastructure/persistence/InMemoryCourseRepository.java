package study.ddd.skeleton.mooc.course.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.course.domain.Course;
import study.ddd.skeleton.mooc.course.domain.CourseId;
import study.ddd.skeleton.mooc.course.domain.CourseRepository;

import java.util.HashMap;
import java.util.Optional;

//@Service
public final class InMemoryCourseRepository implements CourseRepository {

    private HashMap<CourseId, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        this.courses.put(course.getId(), course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id));
    }


}