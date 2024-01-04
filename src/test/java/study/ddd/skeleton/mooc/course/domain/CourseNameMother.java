package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.WordMother;

public class CourseNameMother {
    public static CourseName create(String value) {
        return new CourseName(value);
    }

    public static CourseName random() {
        return create(WordMother.random());
    }
}