package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.StringValueObject;

public class CourseName extends StringValueObject {
    public CourseName(String value) {
        super(value);
    }

    public CourseName() {
        super("");
    }

}
