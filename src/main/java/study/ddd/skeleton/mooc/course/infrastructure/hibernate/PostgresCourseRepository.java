package study.ddd.skeleton.mooc.course.infrastructure.hibernate;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.course.domain.Course;
import study.ddd.skeleton.mooc.course.domain.CourseId;
import study.ddd.skeleton.mooc.course.domain.CourseRepository;
import study.ddd.skeleton.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Service
public class PostgresCourseRepository extends HibernateRepository<Course> implements CourseRepository {

    public PostgresCourseRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Course.class);
    }

    @Override
    @Transactional
    public void save(Course course) {
        persist(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return byId(id);
    }
}
