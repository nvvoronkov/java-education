package lesson.hibernate.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PostDao implements CrudRepository<PostEntity, Long> {

    @Override
    public Optional<PostEntity> findById(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(PostEntity.class, id));
        }
    }

    @Override
    public PostEntity save(final PostEntity postEntity) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(postEntity);
            transaction.commit();
            return postEntity;
        }
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.remove(session.get(PostEntity.class, id));

            transaction.commit();
        }
    }

    @Override
    public List<PostEntity> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PostEntity> criteriaQuery = criteriaBuilder.createQuery(PostEntity.class);
        Root<PostEntity> postRoot = criteriaQuery.from(PostEntity.class);

        criteriaQuery.select(postRoot);

        List<PostEntity> posts = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return posts;
    }
}
