package study.ddd.skeleton.mooc.course.domain;

import study.ddd.skeleton.shared.domain.IntegerMother;
import study.ddd.skeleton.shared.domain.RandomElementPicker;

public class CourseDurationMother {

    public static CourseDuration create(String value) {
        return new CourseDuration(value);
    }

    public static CourseDuration random() {
        return create(
                String.format(
                        "%s %s",
                        IntegerMother.random(),
                        RandomElementPicker.from("years", "months", "days", "hours", "minutes", "seconds")
                )
        );
    }

}
