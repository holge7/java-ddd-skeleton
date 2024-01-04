package study.ddd.skeleton.mooc.courses_counter.application.find;

import study.ddd.skeleton.shared.domain.IntegerMother;

public class CoursesCounterResponseMother {

    public static CoursesCounterResponse create(Integer value) {
        return new CoursesCounterResponse(value);
    }

    public static CoursesCounterResponse random() {
        return create(IntegerMother.random());
    }

}