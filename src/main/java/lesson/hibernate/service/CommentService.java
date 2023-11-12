package lesson.hibernate.service;

import lesson.hibernate.dao.CommentDao;
import lesson.hibernate.entity.CommentEntity;
import lesson.hibernate.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public void addOrUpdateComment(final CommentEntity commentEntity) {
        if (commentEntity.getId() == null) {
            log.info("Добавляем новый комментарий: " + commentEntity.getComment());
            commentDao.save(commentEntity);
        } else {
            log.info("Обновляем комментарий");
            commentDao.save(commentEntity);
        }
    }

    public void deleteComment(final Long id) {
        if (isUserInBase(id)) {
            commentDao.delete(id);
            log.info("Комментарий с id " + id + " удален");
        }

    }

    public List<CommentEntity> getListOfComments() {
        List<CommentEntity> entityList = commentDao.findAll();
        if (entityList.isEmpty()) {
            log.info("Список комментариев пуст");
            throw new UserNotFoundException("Список комментариев пуст");
        }
        return entityList;
    }

    public Optional<CommentEntity> getCommentById(final Long id) {
        Optional<CommentEntity> commentEntity = commentDao.findById(id);
        if (commentEntity.isEmpty()) {
            log.info("Комментария с id = " + id + " нет в базе");
            throw new UserNotFoundException("Комментария с id = " + id + " нет в базе");
        }
        return commentEntity;
    }

    private boolean isUserInBase(final CommentEntity commentEntity) {
        if (commentEntity.getId() == null) {
            log.info("Комментария нет в базе");
            throw new UserNotFoundException("Комментария с id = " + commentEntity.getId() + " нет в базе");
        }
        return true;
    }

    private boolean isUserInBase(final Long id) {
        if (commentDao.findById(id).isEmpty()) {
            log.info("Комментария с id = " + id + " нет в базе");
            throw new UserNotFoundException("Комментария с id = " + id + " нет в базе");
        }
        return true;
    }
}
