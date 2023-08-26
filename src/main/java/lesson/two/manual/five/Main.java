package lesson.two.manual.five;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Main {
    public static void main(final String[] args) {
        Person[] personArr = {
                new Person(1, "Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                        "892312312", 30000, 30),
                new Person(2, "Volkov Ivan Ivanovich", "Engineer", "volkov@mailbox.com",
                        "89991112233", 45000, 33),
                new Person(3, "Kozlov Pavel Pavlovich", "Manager", "kozlov@mailbox.com",
                        "89039998877", 50000, 25),
                new Person(4, "Petrov Petr Petrovich", "Manager", "petrov@mailbox.com",
                        "89012223344", 70000, 45),
                new Person(5, "Putin Vladimir Vladimirovich", "President", "putin@mailbox.com",
                        "89001112233", 1500000, 70)
        };
        for (Person allPersons : personArr) {
            if (allPersons.getAge() > 40) {
                allPersons.getInfoOfColleague(allPersons);
            }
        }
    }
}
