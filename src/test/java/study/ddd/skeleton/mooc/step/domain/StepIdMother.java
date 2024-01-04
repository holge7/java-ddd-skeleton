package study.ddd.skeleton.mooc.step.domain;

import study.ddd.skeleton.mooc.steps.domain.StepId;
import study.ddd.skeleton.shared.domain.UuidMother;

public final class StepIdMother {

    public static StepId create(String value) {
        return new StepId(value);
    }

    public static StepId random() {
        return create(UuidMother.random());
    }

}