package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.mooc.course.application.create.CreateCourseCommand;
import study.ddd.skeleton.mooc.course.application.create.CreateCourseRequest;

public final class CreateCourseMother {

    public static Course create(CourseId id, CourseName name, CourseDuration duration) {
        return new Course(id, name, duration);
    }

    public static Course fromRequest(CreateCourseCommand request) {
        return create(
                CourseIdMother.create(request.id()),
                CourseNameMother.create(request.name()),
                CourseDurationMother.create(request.duration())
        );
    }

    public static Course random() {
        return create(
                CourseIdMother.random(),
                CourseNameMother.random(),
                CourseDurationMother.random()
        );
    }

}
