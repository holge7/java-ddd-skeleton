package study.ddd.skeleton.mooc.courses_counter.application.find;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounter;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounterNotInitialized;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounterRepository;

@Service
public final class CoursesCounterFinder {
    private final CoursesCounterRepository repository;

    public CoursesCounterFinder(CoursesCounterRepository repository) {
        this.repository = repository;
    }

    public CoursesCounterResponse find() {
        CoursesCounter coursesCounter = repository.search().orElseGet(() -> {
            throw new CoursesCounterNotInitialized();
        });

        return new CoursesCounterResponse(coursesCounter.total().value());
    }
}