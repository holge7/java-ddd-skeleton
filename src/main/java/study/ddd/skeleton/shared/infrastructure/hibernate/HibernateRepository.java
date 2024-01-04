package study.ddd.skeleton.shared.infrastructure.hibernate;

import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;
import study.ddd.skeleton.shared.domain.Identifier;

import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {

    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;


    protected HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected Optional<T> byId(Identifier id){
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected List<T> all() {
        CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);

        criteria.from(aggregateClass);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

}