package study.ddd.skeleton.mooc.student.infrastructure.persistence.hibernate;

import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.student.domain.Student;
import study.ddd.skeleton.mooc.student.domain.StudentId;
import study.ddd.skeleton.mooc.student.domain.StudentRepository;
import study.ddd.skeleton.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Service
public class PostgresStudentRepository extends HibernateRepository<Student> implements StudentRepository {

    public PostgresStudentRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Student.class);
    }

    @Override
    @Transactional
    public void save(Student student) {
        persist(student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return byId(id);
    }

}
