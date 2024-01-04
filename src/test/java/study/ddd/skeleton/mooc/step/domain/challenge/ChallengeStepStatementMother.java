package study.ddd.skeleton.mooc.step.domain.challenge;

import study.ddd.skeleton.mooc.steps.domain.challenge.ChallengeStepStatement;
import study.ddd.skeleton.shared.domain.WordMother;

public final class ChallengeStepStatementMother {

    public static ChallengeStepStatement create(String value) {
        return new ChallengeStepStatement(value);
    }

    public static ChallengeStepStatement random() {
        return create(WordMother.random());
    }

}