package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.shared.domain.AggregateRoot;
import study.ddd.skeleton.shared.domain.student.StudentCreatedDomainEvent;

import java.util.Objects;

public class Student extends AggregateRoot {

    private StudentId id;
    private StudentName name;
    private StudentSurname surname;
    private StudentEmail email;

    public Student(StudentId id, StudentEmail email, StudentName name, StudentSurname surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Student() {
    }

    public static Student create(StudentId id, StudentEmail email, StudentName name, StudentSurname surname) {
        Student student = new Student(id, email, name, surname);

        student.record(new StudentCreatedDomainEvent(id.value(), email.value(), name.value(), surname.value()));

        return student;
    }

    public StudentId id() {
        return id;
    }

    public StudentName name() {
        return name;
    }

    public StudentSurname surname() {
        return surname;
    }

    public StudentEmail email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }
}