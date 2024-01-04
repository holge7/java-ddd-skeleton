package study.ddd.skeleton.mooc.step.domain.video;

import study.ddd.skeleton.mooc.steps.domain.video.VideoStepText;
import study.ddd.skeleton.shared.domain.WordMother;

public final class VideoStepTextMother {

    public static VideoStepText create(String value) {
        return new VideoStepText(value);
    }

    public static VideoStepText random() {
        return new VideoStepText(WordMother.random());
    }

}