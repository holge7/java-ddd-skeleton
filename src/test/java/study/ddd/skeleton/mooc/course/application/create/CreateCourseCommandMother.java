package study.ddd.skeleton.mooc.course.application.create;

import study.ddd.skeleton.mooc.course.domain.*;

public class CreateCourseCommandMother {

    public static CreateCourseCommand create(CourseId id, CourseName name, CourseDuration duration) {
        return new CreateCourseCommand(id.value(), name.value(), duration.value());
    }

    public static CreateCourseCommand random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }

}
