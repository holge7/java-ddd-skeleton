package study.ddd.skeleton.shared.domain.student;

import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class StudentCreatedDomainEvent extends DomainEvent {
    private final String email;
    private final String name;
    private final String surname;

    public StudentCreatedDomainEvent(String aggregatedId, String email, String name, String surname) {
        super(aggregatedId);
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public StudentCreatedDomainEvent() {
        this.email = null;
        this.name = null;
        this.surname = null;
    }

    public StudentCreatedDomainEvent(String aggregatedId, String eventId, String occurredOn, String email, String name, String surname) {
        super(aggregatedId, eventId, occurredOn);
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String eventName() {
        return "student.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
           put("email", email);
           put("name", name);
           put("surname", surname);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new StudentCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("email"),
                (String) body.get("name"),
                (String) body.get("surname")
        );
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
        return "StudentCreatedDomainEvent{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCreatedDomainEvent that = (StudentCreatedDomainEvent) o;
        return Objects.equals(email, that.email) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, surname);
    }
}
