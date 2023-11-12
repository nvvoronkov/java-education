package lesson.hibernate.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson.hibernate.entity.UserEntity;
import lesson.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class UserDao implements CrudRepository<UserEntity, Long> {
    @Override
    public Optional<UserEntity> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(UserEntity.class, id));
        }
    }

    @Override
    public UserEntity save(final UserEntity userEntity) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.merge(userEntity);
            transaction.commit();
            return userEntity;
        }
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.remove(session.get(UserEntity.class, id));
            transaction.commit();
        }
    }

    @Override
    public List<UserEntity> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
            Root<UserEntity> postRoot = criteriaQuery.from(UserEntity.class);

            criteriaQuery.select(postRoot);

            return session.createQuery(criteriaQuery).getResultList();
        }
    }
}
