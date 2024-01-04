package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.course.CourseCreatedDomainEvent;

public final class CourseCreatedDomainEventMother {
    public static CourseCreatedDomainEvent create(CourseId id, CourseName name, CourseDuration duration) {
        return new CourseCreatedDomainEvent(id.value(), name.value(), duration.value());
    }

    public static CourseCreatedDomainEvent fromCourse(Course course) {
        return create(course.getId(), course.getName(), course.getDuration());
    }

    public static CourseCreatedDomainEvent random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }

}