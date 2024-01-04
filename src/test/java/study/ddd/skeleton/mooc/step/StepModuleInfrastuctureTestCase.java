package study.ddd.skeleton.mooc.step;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.ddd.skeleton.mooc.steps.infrastructure.persistence.hibernate.PostgresStepRepository;

@SpringBootTest
public class StepModuleInfrastuctureTestCase {

    @Autowired
    protected PostgresStepRepository repository;

}
