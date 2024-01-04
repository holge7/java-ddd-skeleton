package study.ddd.skeleton.app.controller.courses_counter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.ddd.skeleton.mooc.courses_counter.application.find.CoursesCounterResponse;
import study.ddd.skeleton.mooc.courses_counter.application.find.FindCoursesCounterQuery;
import study.ddd.skeleton.shared.domain.bus.command.CommandBus;
import study.ddd.skeleton.shared.domain.bus.query.QueryBus;
import study.ddd.skeleton.shared.domain.bus.query.QueryHandlerExecutionError;
import study.ddd.skeleton.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public class CoursesCounterGetController extends ApiController {

    protected CoursesCounterGetController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @GetMapping("/courses-counter")
    public HashMap<String, Integer> index() throws QueryHandlerExecutionError {
        CoursesCounterResponse response = ask(new FindCoursesCounterQuery());

        return new HashMap<String, Integer>() {
            {
                put("total", response.total());
            }
        };
    }


}