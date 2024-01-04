package study.ddd.skeleton.mooc.student.infrastructure.persistence;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.student.domain.Student;
import study.ddd.skeleton.mooc.student.domain.StudentId;
import study.ddd.skeleton.mooc.student.domain.StudentRepository;

import java.util.HashMap;
import java.util.Optional;

//@Service
public class InMemoryStudentRepository implements StudentRepository {

    HashMap<StudentId, Student> students = new HashMap<>();

    @Override
    public void save(Student student) {
        students.put(student.id(), student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return Optional.ofNullable(students.get(id));
    }
}
