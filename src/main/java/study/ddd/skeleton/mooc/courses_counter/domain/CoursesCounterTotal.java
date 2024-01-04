package study.ddd.skeleton.mooc.courses_counter.domain;

import study.ddd.skeleton.shared.domain.IntValueObject;

public class CoursesCounterTotal extends IntValueObject {

    public CoursesCounterTotal(Integer value) {
        super(value);
    }

    public CoursesCounterTotal() {
        super();
    }

    public static CoursesCounterTotal initialize() {
        return new CoursesCounterTotal(0);
    }

    public CoursesCounterTotal increment() {
        return new CoursesCounterTotal(value() + 1);
    }

}