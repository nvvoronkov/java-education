package lesson.hibernate.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lesson.hibernate.entity.CommentEntity;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.utils.HibernateUtils;
import lesson.nio.repository.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class CommentDao implements CrudRepository<CommentEntity, Long> {
    private final SessionFactory sessionFactory;

    public CommentDao() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Optional<CommentEntity> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CommentEntity> save(final CommentEntity commentEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<CommentEntity> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(CommentEntity.class);
        Root<CommentEntity> commentRoot = criteriaUpdate.from(CommentEntity.class);

        criteriaUpdate.set(commentRoot.get("comment"), commentEntity.getComment());
        criteriaUpdate.where(criteriaBuilder.equal(commentRoot.get("id"), commentEntity.getId()));
        session.persist(criteriaUpdate);

        transaction.commit();
        session.close();
        return Optional.of(commentEntity);
    }

    @Override
    public void delete(final Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaDelete<CommentEntity> commentDelete = criteriaBuilder.createCriteriaDelete(CommentEntity.class);
        Root<CommentEntity> commentRoot = commentDelete.from(CommentEntity.class);

        commentDelete.where(criteriaBuilder.equal(commentRoot.get("id"), id));

        session.persist(commentDelete);

        transaction.commit();
        session.close();
    }

    @Override
    public List<CommentEntity> findAll() {

        return null;
    }

    public List<CommentEntity> findCommentByPost(final PostEntity post) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CommentEntity> criteriaQuery = criteriaBuilder.createQuery(CommentEntity.class);
        Root<CommentEntity> commentRoot = criteriaQuery.from(CommentEntity.class);

        criteriaQuery.select(commentRoot);
        criteriaQuery.where(criteriaBuilder.equal(commentRoot.get("post"), post));

        List<CommentEntity> comments = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return comments;
    }

    public void addNewComment(final Long postId, final String text) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        PostEntity post = session.get(PostEntity.class, postId);
        CommentEntity newComment = CommentEntity.builder()
            .postEntity(post)
            .comment(text)
            .build();

        session.persist(newComment);

        transaction.commit();
        session.close();
    }
}
