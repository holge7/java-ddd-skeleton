package study.ddd.skeleton.shared.infrastructure.spring;

import study.ddd.skeleton.shared.domain.bus.command.Command;
import study.ddd.skeleton.shared.domain.bus.command.CommandBus;
import study.ddd.skeleton.shared.domain.bus.command.CommandHandlerExecutionError;
import study.ddd.skeleton.shared.domain.bus.query.Query;
import study.ddd.skeleton.shared.domain.bus.query.QueryBus;
import study.ddd.skeleton.shared.domain.bus.query.QueryHandlerExecutionError;

public abstract class ApiController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    protected ApiController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    protected void dispatch(Command command) throws CommandHandlerExecutionError {
        commandBus.dispatch(command);
    }

    protected <R> R ask(Query query) throws QueryHandlerExecutionError {
        return queryBus.ask(query);
    }

}