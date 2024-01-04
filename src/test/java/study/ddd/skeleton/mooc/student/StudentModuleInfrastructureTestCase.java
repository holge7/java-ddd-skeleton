package study.ddd.skeleton.mooc.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import study.ddd.skeleton.SkeletonApplication;
import study.ddd.skeleton.mooc.student.infrastructure.persistence.InMemoryStudentRepository;
import study.ddd.skeleton.mooc.student.infrastructure.persistence.hibernate.PostgresStudentRepository;

@ContextConfiguration(classes = SkeletonApplication.class) // Para que cargue el contexto de esta aplicación
// en el caso de que tuvieramos más aplicaciones
@SpringBootTest
public abstract class StudentModuleInfrastructureTestCase {
    protected InMemoryStudentRepository inMemoryCourseRepository =  new InMemoryStudentRepository();

    @Autowired
    protected PostgresStudentRepository postgresStudentRepository;


}
