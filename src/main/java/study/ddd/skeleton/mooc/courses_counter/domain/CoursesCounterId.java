package study.ddd.skeleton.mooc.courses_counter.domain;

import study.ddd.skeleton.shared.domain.Identifier;

public class CoursesCounterId extends Identifier {
    public CoursesCounterId(String value) {
        super(value);
    }

    private CoursesCounterId() {
        super();
    }

}