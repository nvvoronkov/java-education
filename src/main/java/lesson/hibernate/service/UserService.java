package lesson.hibernate.service;

import lesson.hibernate.dao.UserDao;
import lesson.hibernate.entity.UserEntity;
import lesson.hibernate.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void addOrUpdateUser(final UserEntity userEntity) {
        if (userEntity.getId() == null) {
            log.info("Добавляем нового пользователя с именем " + userEntity.getName());
            userDao.save(userEntity);
        } else {
            log.info("Обновляем данные пользователя");
            userDao.save(userEntity);
        }
    }

    public void deleteUser(final Long id) {
        if (isUserInBase(id)) {
            userDao.delete(id);
            log.info("пользователь с id " + id + " удален");
        }
    }

    public Optional<UserEntity> getById(final Long id) {
        Optional<UserEntity> userEntity = userDao.findById(id);
        if (userEntity.isEmpty()) {
            log.info("пользователя с id = " + id + " нет в базе");
            throw new UserNotFoundException("пользователя с id = " + id + " нет в базе");
        }
        return userEntity;
    }

    public List<UserEntity> getListOfUsers() {
        List<UserEntity> entityList = userDao.findAll();
        if (entityList.isEmpty()) {
            log.info("список пользователей пуст");
            throw new UserNotFoundException("список пользователей пуст");
        }
        return entityList;
    }

    public Optional<UserEntity> findUserHavingMostPosts() {
        List<UserEntity> entityList = getListOfUsers();

        Optional<UserEntity> userEntity = entityList.stream()
            .max(Comparator.comparingInt(user -> user.getPostEntityList().size()));
        log.info(userEntity.map(UserEntity::getName) + " имеет наибольшее количество постов.");
        return userEntity;
    }

    private boolean isUserInBase(final UserEntity userEntity) {
        if (userEntity.getId() == null) {
            log.info("пользователя нет в базе");
            throw new UserNotFoundException("пользователя с id = " + userEntity.getId() + " нет в базе");
        }
        return true;
    }

    private boolean isUserInBase(final Long id) {
        if (userDao.findById(id).isEmpty()) {
            log.info("пользователя с id = " + id + " нет в базе");
            throw new UserNotFoundException("пользователя с id = " + id + " нет в базе");
        }
        return true;
    }
}
