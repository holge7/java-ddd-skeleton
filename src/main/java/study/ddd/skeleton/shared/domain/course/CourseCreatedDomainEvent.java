package study.ddd.skeleton.shared.domain.course;

import study.ddd.skeleton.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class CourseCreatedDomainEvent extends DomainEvent {

    private final String name;
    private final String duration;

    public CourseCreatedDomainEvent() {
        super(null);

        this.name = null;
        this.duration = null;
    }

    public CourseCreatedDomainEvent(String aggregateId, String name, String duration){
        super(aggregateId);
        this.name = name;
        this.duration = duration;
    }

    public CourseCreatedDomainEvent(
            String aggregatedId,
            String eventId,
            String occurredOn,
            String name,
            String duration
    ) {
        super(aggregatedId, eventId, occurredOn);
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String eventName() {
        return "course.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("duration", duration);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CourseCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name"),
                (String) body.get("duration")
        );
    }

    public String name() {
        return name;
    }

    public String duration() {
        return duration;
    }

//    @Override
//    public String toString() {
//        return "CourseCreatedDomainEvent{" +
//                "name='" + name + '\'' +
//                ", duration='" + duration + '\'' +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCreatedDomainEvent that = (CourseCreatedDomainEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }
}