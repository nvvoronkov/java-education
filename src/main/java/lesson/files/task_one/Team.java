package lesson.files.task_one;

import lombok.Data;

import java.util.Arrays;

@Data
public class Team {
    private final String name;
    private final String[] teamArray;

    public Team(final String name, final String first, final String second, final String third,
                final String forth) {
        this.name = name;
        this.teamArray = new String[]{first, second, third, forth};
    }

    @Override
    public String toString() {
        return "Team{"
                + "name='" + name + '\''
                + ", teamArray=" + Arrays.toString(teamArray)
                + '}';
    }
}
