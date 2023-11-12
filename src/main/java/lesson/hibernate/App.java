package lesson.hibernate;

import lesson.hibernate.dao.CommentDao;
import lesson.hibernate.dao.PostDao;
import lesson.hibernate.dao.UserDao;
import lesson.hibernate.entity.CommentEntity;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.entity.PostType;
import lesson.hibernate.entity.UserEntity;
import lesson.hibernate.service.CommentService;
import lesson.hibernate.service.PostService;
import lesson.hibernate.service.UserService;

// todo: https://www.geeksforgeeks.org/hibernate-lifecycle/

// todo: insert, update, remove
// todo: session/session factory/ transaction/ какими способами мы можем получить данные из БД через хибер
// todo: n + 1, Lazy vs Eager
public class App {
    public static void main(final String[] args) {
        PostDao postDao = new PostDao();
        PostService postService = new PostService(postDao);

        CommentDao commentDao = new CommentDao();
        CommentService commentService = new CommentService(commentDao);

        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);

        PostEntity post1 = PostEntity.builder()
            .name("post")
            .postType(PostType.LIFESTYLE)
            .build()
            .withComment(CommentEntity.builder()
                .comment("123")
                .build());

        UserEntity user1 = UserEntity.builder()
            .name("Nikita")
            .email("1234@mail.ru")
            .build()
            .withPost(post1);

        PostEntity post2 = PostEntity.builder()
            .name("post post")
            .postType(PostType.LIFESTYLE)
            .build()
            .withComment(CommentEntity.builder()
                .comment("123")
                .build());

        UserEntity user2 = UserEntity.builder()
            .name("Max")
            .email("1234@mail.ru")
            .build();

        UserEntity user3 = UserEntity.builder()
            .id(2L)
            .name("Max")
            .email("1234@mail.ru")
            .build()
            .withPost(post2);

        CommentEntity comment1 = CommentEntity.builder()
            .comment("hello")
            .postEntity(post2)
            .build();

        userService.addOrUpdateUser(user2);
        userService.addOrUpdateUser(user1);
        userService.addOrUpdateUser(user3);
        commentService.addOrUpdateComment(comment1);

        userService.findUserHavingMostPosts();
        postService.findMostCommentedPost();


    }
}
