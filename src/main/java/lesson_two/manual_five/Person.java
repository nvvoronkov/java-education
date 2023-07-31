package lesson_two.manual_five;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private String post;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public void getInfoOfColleague(Person person) {
        System.out.println(person.toString());
    }
}
