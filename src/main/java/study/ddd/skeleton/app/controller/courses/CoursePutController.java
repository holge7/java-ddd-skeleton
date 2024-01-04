package study.ddd.skeleton.app.controller.courses;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.ddd.skeleton.mooc.course.application.create.CreateCourseCommand;
import study.ddd.skeleton.shared.domain.bus.command.CommandBus;
import study.ddd.skeleton.shared.domain.bus.query.QueryBus;
import study.ddd.skeleton.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import study.ddd.skeleton.shared.infrastructure.spring.ApiController;

@RestController
public class CoursePutController extends ApiController {
    @Autowired
    RabbitMqDomainEventsConsumer consumer;

    public CoursePutController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<String> create(@PathVariable("id") String id, @RequestBody Request request) {
        dispatch(new CreateCourseCommand(id, request.name(), request.duration()));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/consume")
    public void consume() {
        consumer.consume();
    }

}

@Data
final class Request{
    String name;
    String duration;

    public String name() {
        return name;
    }

    public String duration() {
        return duration;
    }
}