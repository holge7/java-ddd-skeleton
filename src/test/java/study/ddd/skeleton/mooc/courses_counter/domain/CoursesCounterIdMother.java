package study.ddd.skeleton.mooc.courses_counter.domain;

import study.ddd.skeleton.shared.domain.UuidMother;

public final class CoursesCounterIdMother {

    public static CoursesCounterId create(String value) {
        return new CoursesCounterId(value);
    }

    public static CoursesCounterId random() {
        return create(UuidMother.random());
    }

}