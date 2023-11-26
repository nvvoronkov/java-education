package lesson.hibernate;

import lesson.hibernate.dao.PostRepository;
import lesson.hibernate.dao.UserDao;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.entity.PostType;
import lesson.hibernate.entity.UserEntity;
import lesson.hibernate.service.UserService;

import java.util.List;

// todo: https://www.geeksforgeeks.org/hibernate-lifecycle/
// todo: insert, update, remove
// todo: session/session factory/ transaction/ какими способами мы можем получить данные из БД через хибер
// todo: n + 1, Lazy vs Eager
public class App {
    public static void main(final String[] args) {
        /*PostDao postDao = new PostDao();*/

        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);

        UserEntity user1 = UserEntity.builder()
            .name("Nikita")
            .email("1234@mail.ru")
            .build()
            .withPost(PostEntity.builder()
                .name("post")
                .postType(PostType.LIFESTYLE)
                .build());
        UserEntity user2 = UserEntity.builder()
            .name("Nikita")
            .email("1234@mail.ru")
            .build()
            .withPost(PostEntity.builder()
                .name("post")
                .postType(PostType.LIFESTYLE)
                .build());
        UserEntity user3 = UserEntity.builder()
            .name("Nikita")
            .email("1234@mail.ru")
            .build()
            .withPost(PostEntity.builder()
                .name("post")
                .postType(PostType.LIFESTYLE)
                .build());

        userService.addOrUpdateUser(user1);
        userService.addOrUpdateUser(user2);
        userService.addOrUpdateUser(user3);

        PostRepository postRepository = new PostRepository();

        // todo n + 1
        List<PostEntity> all = postRepository.findAll();
        for (PostEntity postEntity : all) {
            System.out.println(postEntity.getUserEntity());
        }

    }
}
