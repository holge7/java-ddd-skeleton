package study.ddd.skeleton.mooc.step.domain.challenge;

import study.ddd.skeleton.mooc.step.domain.StepIdMother;
import study.ddd.skeleton.mooc.step.domain.StepTitleMother;
import study.ddd.skeleton.mooc.steps.domain.StepId;
import study.ddd.skeleton.mooc.steps.domain.StepTitle;
import study.ddd.skeleton.mooc.steps.domain.challenge.ChallengeStep;
import study.ddd.skeleton.mooc.steps.domain.challenge.ChallengeStepStatement;

public final class ChallengeStepMother {

    public static ChallengeStep create(StepId id, StepTitle title, ChallengeStepStatement statement) {
        return new ChallengeStep(id, title, statement);
    }

    public static ChallengeStep random() {
        return create(
                StepIdMother.random(),
                StepTitleMother.random(),
                ChallengeStepStatementMother.random()
        );
    }

}