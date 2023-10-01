package lesson.hibernate;

import lesson.hibernate.entity.User;
import lesson.hibernate.utils.HibernateUtils;

public class App {
    public static void main(String[] args) {
        User user = User.builder()
                .name("sdasd")
                .email("sdsa@mail.ru")
                .build();

        try (var session = HibernateUtils.getSessionFactory().openSession()) {
            var transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        }
    }
}
