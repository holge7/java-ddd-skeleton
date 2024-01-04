package study.ddd.skeleton.mooc.steps.domain.video;

import study.ddd.skeleton.mooc.steps.domain.Step;
import study.ddd.skeleton.mooc.steps.domain.StepId;
import study.ddd.skeleton.mooc.steps.domain.StepTitle;

public final class VideoStep extends Step {
    private final VideoUrl videoUrl;
    private final VideoStepText text;

    public VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
        super(id, title);
        this.videoUrl = videoUrl;
        this.text = text;
    }

    public VideoStep() {
        super(null, null);

        this.videoUrl = null;
        this.text = null;
    }
}