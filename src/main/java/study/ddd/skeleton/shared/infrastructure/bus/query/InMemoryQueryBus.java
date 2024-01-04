package study.ddd.skeleton.shared.infrastructure.bus.query;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.query.*;

@Service
public class InMemoryQueryBus implements QueryBus {
    private final QueryHandlerInformation information;
    private final ApplicationContext context;

    public InMemoryQueryBus(QueryHandlerInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public Response ask(Query query) throws QueryHandlerExecutionError {
        try {
            Class<? extends QueryHandler> queryHandlerClass = information.search(query.getClass());

            QueryHandler handler = context.getBean(queryHandlerClass);

            return handler.handle(query);
        } catch (Throwable error) {
            throw new QueryHandlerExecutionError(error);
        }
    }
}
