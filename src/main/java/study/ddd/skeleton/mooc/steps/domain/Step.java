package study.ddd.skeleton.mooc.steps.domain;

import java.util.Objects;

public abstract class Step {

    private final StepId id;
    private final StepTitle title;

    protected Step(StepId id, StepTitle title) {
        this.id = id;
        this.title = title;
    }

    public StepId id(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(id, step.id) && Objects.equals(title, step.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}