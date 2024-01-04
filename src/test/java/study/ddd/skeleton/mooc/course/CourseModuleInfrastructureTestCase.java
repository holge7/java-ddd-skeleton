package study.ddd.skeleton.mooc.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import study.ddd.skeleton.SkeletonApplication;
import study.ddd.skeleton.mooc.course.domain.CourseRepository;
import study.ddd.skeleton.mooc.course.infrastructure.persistence.InMemoryCourseRepository;

@ContextConfiguration(classes = SkeletonApplication.class) // Para que cargue el contexto de esta aplicación
// en el caso de que tuvieramos más aplicaciones
@SpringBootTest
public abstract class CourseModuleInfrastructureTestCase {
    protected InMemoryCourseRepository inMemoryCourseRepository =  new InMemoryCourseRepository();

    @Autowired
    protected CourseRepository postgresCourseRepository;


}
