package study.ddd.skeleton.mooc.courses_counter.application.find;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCoursesCounterQueryHandler implements QueryHandler<FindCoursesCounterQuery, CoursesCounterResponse> {
    private final CoursesCounterFinder finder;

    public FindCoursesCounterQueryHandler(CoursesCounterFinder finder) {
        this.finder = finder;
    }

    @Override
    public CoursesCounterResponse handle(FindCoursesCounterQuery query) {
        return finder.find();
    }
}