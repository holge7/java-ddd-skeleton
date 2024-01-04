package study.ddd.skeleton.mooc.step.domain;

import study.ddd.skeleton.mooc.steps.domain.StepTitle;
import study.ddd.skeleton.shared.domain.WordMother;

public final class StepTitleMother {

    public static StepTitle create(String value) {
        return new StepTitle(value);
    }

    public static StepTitle random() {
        return new StepTitle(WordMother.random());
    }

}
