package lesson.objects.manual.five;

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
}
