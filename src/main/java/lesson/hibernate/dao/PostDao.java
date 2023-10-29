package lesson.hibernate.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.utils.HibernateUtils;
import lesson.nio.repository.CrudRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PostDao implements CrudRepository<PostEntity, Long> {
    private final SessionFactory sessionFactory;

    public PostDao() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Optional<PostEntity> findById(final Long id) {
        Session session = sessionFactory.openSession();
        Optional<PostEntity> postEntity = Optional.ofNullable(session.get(PostEntity.class, id));
        session.close();
        return postEntity;

    }

    @Override
    public Optional<PostEntity> save(final PostEntity postEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        PostEntity newPost = PostEntity.builder()
            .name(postEntity.getName())
            .postType(postEntity.getPostType())
            .commentEntityList(postEntity.getCommentEntityList())
            .build();

        session.persist(newPost);

        transaction.commit();
        session.close();
        return Optional.ofNullable(newPost);
    }

    @Override
    public void delete(final Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<PostEntity> postDelete = criteriaBuilder.createCriteriaDelete(PostEntity.class);
        Root<PostEntity> postRoot = postDelete.from(PostEntity.class);

        postDelete.where(criteriaBuilder.equal(postRoot.get("id"), id));

        session.persist(postDelete);

        transaction.commit();
        session.close();
    }

    @Override
    public List<PostEntity> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PostEntity> criteriaQuery = criteriaBuilder.createQuery(PostEntity.class);
        Root<PostEntity> postRoot = criteriaQuery.from(PostEntity.class);

        criteriaQuery.select(postRoot);

        List<PostEntity> posts = session.createQuery(criteriaQuery).getResultList();

        session.close();
        return posts;
    }
}
