package study.ddd.skeleton.mooc.steps.domain;

import java.util.Optional;

public interface StepRepository {

    void save(Step step);

    Optional<? extends Step> search(StepId id);

}
