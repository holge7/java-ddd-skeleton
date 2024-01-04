package study.ddd.skeleton.mooc.student.application.create;

import study.ddd.skeleton.shared.domain.bus.command.Command;

public class CreateStudentCommand implements Command {
    private final String id;
    private final String email;
    private final String name;
    private final String surname;

    public CreateStudentCommand(String id, String email, String name, String surName) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surName;
    }

    public String id() {
        return id;
    }

    public String email() {
        return email;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    @Override
    public String toString() {
        return "CreateStudentCommand{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}