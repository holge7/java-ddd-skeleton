package study.ddd.skeleton.mooc.course.domain;

import lombok.*;
import study.ddd.skeleton.shared.domain.AggregateRoot;
import study.ddd.skeleton.shared.domain.course.CourseCreatedDomainEvent;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Course extends AggregateRoot {

    private CourseId id;
    private CourseName name;
    private CourseDuration duration;

    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        Course course = new Course(id, name, duration);

        course.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value()));

        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(duration, course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}