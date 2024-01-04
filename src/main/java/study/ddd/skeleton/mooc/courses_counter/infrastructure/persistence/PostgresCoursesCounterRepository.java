package study.ddd.skeleton.mooc.courses_counter.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounter;
import study.ddd.skeleton.mooc.courses_counter.domain.CoursesCounterRepository;
import study.ddd.skeleton.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class PostgresCoursesCounterRepository extends HibernateRepository<CoursesCounter> implements CoursesCounterRepository {

    protected PostgresCoursesCounterRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, CoursesCounter.class);
    }

    @Override
    public void save(CoursesCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<CoursesCounter> search() {
        List<CoursesCounter> coursesCounters = all();

        if (coursesCounters.size() == 0) {
            return Optional.empty();
        }

        return Optional.ofNullable(coursesCounters.get(0));
    }
}