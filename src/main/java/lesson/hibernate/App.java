package lesson.hibernate;

import lesson.hibernate.entity.CommentEntity;
import lesson.hibernate.entity.Post;
import lesson.hibernate.entity.PostType;
import lesson.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

// todo: https://www.geeksforgeeks.org/hibernate-lifecycle/

// todo: insert, update, remove
// todo: session/session factory/ transaction/ какими способами мы можем получить данные из БД через хибер
// todo: n + 1, Lazy vs Eager
public class App {
    public static void main(final String[] args) {
        Post post = Post.builder()
            .name("post")
            .postType(PostType.LIFESTYLE)
            .build()
            .withComment(CommentEntity.builder()
                .comment("asdasdaga")
                .build())
            .withComment(CommentEntity.builder()
                .comment("hdaaakkl454432")
                .build());

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(post);
            transaction.commit();
        }
    }
}
