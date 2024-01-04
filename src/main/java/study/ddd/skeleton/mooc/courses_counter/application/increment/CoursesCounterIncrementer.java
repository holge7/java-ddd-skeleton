package study.ddd.skeleton.mooc.courses_counter.application.increment;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.course.domain.CourseId;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounter;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounterRepository;
import study.ddd.skeleton.shared.domain.UuidGenerator;

@Service
public final class CoursesCounterIncrementer {
    private CoursesCounterRepository repository;
    private UuidGenerator uuidGenerator;

    public CoursesCounterIncrementer(CoursesCounterRepository repository, UuidGenerator uuidGenerator) {
        this.repository = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(CourseId id) {
        CoursesCounter counter = repository.search()
                .orElseGet(() -> CoursesCounter.initialize(uuidGenerator.generate()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);

            repository.save(counter);
        }

    }

}