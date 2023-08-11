package lesson.three.task_one;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseTest {
    private final Team team = new Team("Workers", "John", "Jane",
                                 "Bob", "Alice");
    private final Course course = new Course();

    @Test
    public void testCrossWall() {
        course.crossWall(team);
        Assertions.assertThat(team.getTeamArray()[0]).isNotNull();
        Assertions.assertThat(team.getTeamArray()[1]).isNotNull();
        Assertions.assertThat(team.getTeamArray()[2]).isNotNull();
        Assertions.assertThat(team.getTeamArray()[3]).isNotNull();
    }

    @Test
    public void testCrossRiver() {
        course.crossRiver(team);
        Assertions.assertThat(team.getTeamArray()[0]).isNotNull();
        Assertions.assertThat(team.getTeamArray()[1]).isNotNull();
        Assertions.assertThat(team.getTeamArray()[2]).isNotNull();
        Assertions.assertThat(team.getTeamArray()[3]).isNotNull();
    }
}