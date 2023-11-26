package lesson.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.utils.HibernateUtils;

import java.util.List;
import java.util.Optional;

public class PostRepository {
    EntityManager em = HibernateUtils.getEntityManager();

    public Optional<PostEntity> findById(final Long id) {
//        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PostEntity> query = cb.createQuery(PostEntity.class);
        Root<PostEntity> root = query.from(PostEntity.class);

        query.select(root)
            .where(cb.equal(root.get("id"), id));

        Optional<PostEntity> result = Optional.ofNullable(em.createQuery(query).getSingleResult());
//        em.getTransaction().commit();
        return result;
    }

    public PostEntity save(final PostEntity postEntity) {
        em.getTransaction().begin();

        PostEntity result = em.merge(postEntity);

        em.getTransaction().commit();
        return result;
    }

    public void delete(final Long id) {
        em.getTransaction().begin();

        em.remove(id);

        em.getTransaction().commit();
    }

    public List<PostEntity> findAll() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<PostEntity> query = cb.createQuery(PostEntity.class);
            Root<PostEntity> root = query.from(PostEntity.class);

            query.select(root);

            List<PostEntity> resultList = entityManager.createQuery(query).getResultList();
            entityManager.getTransaction().commit();
            return resultList;
        }


    }
}
