package study.ddd.skeleton.mooc.courses_counter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import study.ddd.skeleton.mooc.course.domain.CourseId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CoursesCounter {

    private CoursesCounterId id;
    private CoursesCounterTotal total;
    private List<CourseId> existingCourses;

    public CoursesCounter(CoursesCounterId id, CoursesCounterTotal total, List<CourseId> existingCourses) {
        this.id = id;
        this.total = total;
        this.existingCourses = existingCourses;
    }

    public CoursesCounter() {
        this.id = null;
        this.total = null;
        this.existingCourses = null;
    }

    public static CoursesCounter initialize(String id) {
        return new CoursesCounter(new CoursesCounterId(id), CoursesCounterTotal.initialize(), new ArrayList<>());
    }

    public CoursesCounterId id() {
        return id;
    }

    public CoursesCounterTotal total() {
        return total;
    }

    public List<CourseId> existingCourses() {
        return existingCourses;
    }

    public boolean hasIncremented(CourseId id) {
        return existingCourses.contains(id);
    }

    public void increment(CourseId id) {
        total = total.increment();
        existingCourses.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesCounter that = (CoursesCounter) o;
        return Objects.equals(id, that.id) && Objects.equals(total, that.total) && Objects.equals(existingCourses, that.existingCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingCourses);
    }
}