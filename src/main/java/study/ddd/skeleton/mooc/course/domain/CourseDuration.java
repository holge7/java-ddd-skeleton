package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.StringValueObject;

public class CourseDuration extends StringValueObject {
    public CourseDuration(String value) {
        super(value);
    }
    public CourseDuration() {
        super("");
    }
}
