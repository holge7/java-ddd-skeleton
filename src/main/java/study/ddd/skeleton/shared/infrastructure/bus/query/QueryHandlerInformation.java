package study.ddd.skeleton.shared.infrastructure.bus.query;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.query.Query;
import study.ddd.skeleton.shared.domain.bus.query.QueryHandler;
import study.ddd.skeleton.shared.domain.bus.query.QueryNotRegisteredError;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;

@Service
public class QueryHandlerInformation {
    HashMap<Class<? extends Query>, Class<? extends QueryHandler>> indexedQueryHandler;

    public QueryHandlerInformation() {
        Reflections reflections = new Reflections("study.ddd.skeleton");
        Set<Class<? extends QueryHandler>> classes = reflections.getSubTypesOf(QueryHandler.class);

        indexedQueryHandler = formatHandlers(classes);
    }

    public Class<? extends QueryHandler> search(Class<? extends Query> queryClass) throws QueryNotRegisteredError{
        Class<? extends QueryHandler> queryHandlerClass = indexedQueryHandler.get(queryClass);

        if (null == queryHandlerClass) {
            throw new QueryNotRegisteredError(queryClass);
        }

        return queryHandlerClass;
    }

    private HashMap<Class<? extends Query>, Class<? extends QueryHandler>> formatHandlers(
            Set<Class<? extends QueryHandler>> queryHandlers
    ) {
        HashMap<Class<? extends Query>, Class<? extends QueryHandler>> handlers = new HashMap<>();

        for (Class<? extends QueryHandler> handler : queryHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Query> queryClass = (Class<? extends Query>) paramType.getActualTypeArguments()[0];

            handlers.put(queryClass, handler);
        }

        return handlers;
    }


}