package lesson.hibernate;

import lesson.hibernate.dao.CommentDao;
import lesson.hibernate.dao.PostDao;
import lesson.hibernate.entity.CommentEntity;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.entity.PostType;

import java.util.List;

// todo: https://www.geeksforgeeks.org/hibernate-lifecycle/

// todo: insert, update, remove
// todo: session/session factory/ transaction/ какими способами мы можем получить данные из БД через хибер
// todo: n + 1, Lazy vs Eager
public class App {
    public static void main(final String[] args) {
        PostEntity postEntity = PostEntity.builder()
            .name("post")
            .postType(PostType.LIFESTYLE)
            .build()
            .withComment(CommentEntity.builder()
                .comment("123")
                .build());
        PostEntity postEntity1 = PostEntity.builder()
            .name("post")
            .postType(PostType.LIFESTYLE)
            .build()
            .withComment(CommentEntity.builder()
                .comment("123")
                .build());
        PostEntity postEntity2 = PostEntity.builder()
            .name("post")
            .postType(PostType.LIFESTYLE)
            .build()
            .withComment(CommentEntity.builder()
                .comment("123")
                .build());

        PostDao postDao = new PostDao();
        postDao.save(postEntity);
        postDao.save(postEntity1);
        postDao.save(postEntity2);

        CommentDao commentDao = new CommentDao();
        List<CommentEntity> commentDaoAll = commentDao.findAll();
        commentDaoAll.forEach(System.out::println);

    }
}
