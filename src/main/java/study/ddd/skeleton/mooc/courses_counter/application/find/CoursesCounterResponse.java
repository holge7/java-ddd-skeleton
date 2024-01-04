package study.ddd.skeleton.mooc.courses_counter.application.find;

import study.ddd.skeleton.shared.domain.bus.query.Response;

import java.util.Objects;

public class CoursesCounterResponse implements Response {
    private Integer total;

    public CoursesCounterResponse(Integer total) {
        this.total = total;
    }

    public Integer total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesCounterResponse that = (CoursesCounterResponse) o;
        return Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}