package study.ddd.skeleton.mooc.steps.domain.video;

import study.ddd.skeleton.mooc.steps.domain.StepId;

import java.util.Optional;

public interface VideoRepository {

    void save(VideoStep video);

    Optional<VideoStep> search(StepId id);

}
