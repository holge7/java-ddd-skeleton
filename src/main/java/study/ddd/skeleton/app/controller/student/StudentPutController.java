package study.ddd.skeleton.app.controller.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.ddd.skeleton.mooc.student.application.create.CreateStudentCommand;
import study.ddd.skeleton.shared.domain.bus.command.CommandBus;
import study.ddd.skeleton.shared.domain.bus.query.QueryBus;
import study.ddd.skeleton.shared.infrastructure.spring.ApiController;

@RestController
public final class StudentPutController extends ApiController {


    public StudentPutController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }


    @PutMapping("/student/{id}")
    public ResponseEntity create(@PathVariable(name = "id") String id, @RequestBody Request student) {
        dispatch(new CreateStudentCommand(id, student.email(), student.name(), student.surname()));
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

final class Request {
    String name;
    String surname;
    String email;

    public Request(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Request() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String email() {
        return email;
    }

}
