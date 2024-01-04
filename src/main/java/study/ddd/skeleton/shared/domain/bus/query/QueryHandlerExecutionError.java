package study.ddd.skeleton.shared.domain.bus.query;

public class QueryHandlerExecutionError extends RuntimeException {
    public QueryHandlerExecutionError (Throwable cause) {
        super(cause);
    }
}