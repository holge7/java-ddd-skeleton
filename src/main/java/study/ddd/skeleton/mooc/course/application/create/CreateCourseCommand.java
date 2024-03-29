package study.ddd.skeleton.mooc.course.application.create;

import study.ddd.skeleton.shared.domain.bus.command.Command;

public class CreateCourseCommand implements Command {
    private final String id;
    private final String name;
    private final String duration;

    public CreateCourseCommand(String id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String duration() {
        return duration;
    }
}