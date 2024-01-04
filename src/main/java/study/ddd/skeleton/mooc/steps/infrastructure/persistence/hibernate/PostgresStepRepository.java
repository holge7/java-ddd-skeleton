package study.ddd.skeleton.mooc.steps.infrastructure.persistence.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.ddd.skeleton.mooc.steps.domain.Step;
import study.ddd.skeleton.mooc.steps.domain.StepId;
import study.ddd.skeleton.mooc.steps.domain.StepRepository;
import study.ddd.skeleton.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class PostgresStepRepository extends HibernateRepository<Step> implements StepRepository {
    public PostgresStepRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Step.class);
    }


    @Override
    public void save(Step step) {
        persist(step);
    }

    @Override
    public Optional<? extends Step> search(StepId id) {
        return byId(id);
    }
}
