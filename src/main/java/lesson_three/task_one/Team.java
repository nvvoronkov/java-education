package lesson_three.task_one;

import lombok.Data;

import java.util.Arrays;

@Data
public class Team {
    private String name;
    private String[] teamArray;

    public Team(String name, String first, String second, String third, String forth) {
        this.name = name;
        this.teamArray = new String[]{first, second, third, forth};
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", teamArray=" + Arrays.toString(teamArray) +
                '}';
    }
}
