package lesson_two.manual_five;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    int id;
    String name;
    String post;
    String email;
    String telephone;
    int salary;
    int age;

    public void getInfoOfColleague(Person person) {
        System.out.println(person.toString());
    }
}
