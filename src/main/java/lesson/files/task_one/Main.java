package lesson.files.task_one;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Main {
    public static void main(final String[] args) {
        Course c = new Course(); // Создаем полосу препятствий
        Team team = new Team("Avengers", "Iron-man", "Tor", "Capitan", "Hulk"); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
    }
}
