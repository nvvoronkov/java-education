package lesson.hibernate.service;

import lesson.hibernate.dao.PostDao;
import lesson.hibernate.entity.PostEntity;
import lesson.hibernate.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public void addOrUpdatePost(final PostEntity post) {
        if (post.getId() == null) {
            log.info("Добавляем пост: " + post.getName());
            postDao.save(post);
        } else {
            log.info("Обновляем пост");
            postDao.save(post);
        }
    }

    public void deletePost(final Long id) {
        if (isUserInBase(id)) {
            postDao.delete(id);
            log.info("Пост с id " + id + " удален");
        }
    }

    public List<PostEntity> getListOfPosts() {
        List<PostEntity> entityList = postDao.findAll();
        if (entityList.isEmpty()) {
            log.info("Список постов пуст");
            throw new UserNotFoundException("Список постов пуст");
        }
        return entityList;
    }

    public Optional<PostEntity> getPostById(final Long id) {
        Optional<PostEntity> postEntity = postDao.findById(id);
        if (postEntity.isEmpty()) {
            log.info("Поста с id = " + id + " нет в базе");
            throw new UserNotFoundException("Посат с id = " + id + " нет в базе");
        }
        return postEntity;
    }

    public Optional<PostEntity> findMostCommentedPost() {
        List<PostEntity> postList = getListOfPosts();

        Optional<PostEntity> postEntity = postList.stream()
            .max(Comparator.comparingInt(post -> post.getCommentEntityList().size()));
        log.info("Пост с названием - " + postEntity.map(PostEntity::getName) + " имеет наибольшее количество комментариев.");
        return postEntity;
    }

    private boolean isUserInBase(final PostEntity postEntity) {
        if (postEntity.getId() == null) {
            log.info("поста нет в базе");
            throw new UserNotFoundException("поста с id = " + postEntity.getId() + " нет в базе");
        }
        return true;
    }

    private boolean isUserInBase(final Long id) {
        if (postDao.findById(id).isEmpty()) {
            log.info("поста с id = " + id + " нет в базе");
            throw new UserNotFoundException("поста с id = " + id + " нет в базе");
        }
        return true;
    }
}
