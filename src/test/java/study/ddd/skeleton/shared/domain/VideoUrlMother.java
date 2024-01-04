package study.ddd.skeleton.shared.domain;

import study.ddd.skeleton.mooc.steps.domain.video.VideoUrl;

public final class VideoUrlMother {

    public static VideoUrl create(String value) {
        return new VideoUrl(value);
    }

    public static VideoUrl random() {
        return create(MotherCreator.random().internet().url());
    }


}
