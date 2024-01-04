package study.ddd.skeleton.mooc.step.domain.video;

import study.ddd.skeleton.mooc.step.domain.StepIdMother;
import study.ddd.skeleton.mooc.step.domain.StepTitleMother;
import study.ddd.skeleton.mooc.steps.domain.StepId;
import study.ddd.skeleton.mooc.steps.domain.StepTitle;
import study.ddd.skeleton.mooc.steps.domain.video.VideoStep;
import study.ddd.skeleton.mooc.steps.domain.video.VideoStepText;
import study.ddd.skeleton.mooc.steps.domain.video.VideoUrl;
import study.ddd.skeleton.shared.domain.VideoUrlMother;

public final class VideoStepMother {

    public static VideoStep create(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        return new VideoStep(id, title, videoUrl, text);
    }

    public static VideoStep random() {
        return create(
                StepIdMother.random(),
                StepTitleMother.random(),
                VideoUrlMother.random(),
                VideoStepTextMother.random()
        );
    }

}