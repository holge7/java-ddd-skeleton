package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.UuidMother;

public class CourseIdMother {

    public static CourseId create(String value) {
        return new CourseId(value);
    }

    public static CourseId random() {
        return create(UuidMother.random());
    }
}
