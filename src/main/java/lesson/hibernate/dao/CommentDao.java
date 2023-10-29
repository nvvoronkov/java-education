package lesson.hibernate.dao;

import lesson.hibernate.entity.CommentEntity;
import lesson.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CommentDao implements CrudRepository<CommentEntity, Long> {

    @Override
    public Optional<CommentEntity> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public CommentEntity save(final CommentEntity commentEntity) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(commentEntity);
            transaction.commit();
            return commentEntity;
        }
    }

    @Override
    public void delete(final Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(session.get(CommentEntity.class, id));
            transaction.commit();
        }
    }

    @Override
    public List<CommentEntity> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from CommentEntity", CommentEntity.class).list();
        }
    }
}
