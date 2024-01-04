package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.Identifier;

public final class CourseId extends Identifier {

    public CourseId(String value) {
        super(value);
    }

    public CourseId() {
        super("");
    }

    @Override
    public String toString() {
        return "CourseId{" +
                "value='" + value() + '\'' +
                '}';
    }
}