package lesson_three.task_one;

import java.util.Random;

public class Course {
    public void crossWall(Team team) {
        for (int i = 0; i < team.getTeamArray().length; i++) {
            if (new Random().nextBoolean()) {
                System.out.println(team.getTeamArray()[i] + " crossed the wall");
            } else {
                System.out.println(team.getTeamArray()[i] + " did't cross the wall");
                team.getTeamArray()[i] = null;
            }
        }
    }

    public void crossRiver(Team team) {
        for (int i = 0; i < team.getTeamArray().length; i++) {
            if (team.getTeamArray()[i] != null) {
                if (new Random().nextBoolean()) {
                    System.out.println(team.getTeamArray()[i] + " crossed the river");
                } else {
                    System.out.println(team.getTeamArray()[i] + " did't cross the river");
                    team.getTeamArray()[i] = null;
                }
            }
        }
    }

    public void resultCourse(Team team) {
        for (int i = 0; i < team.getTeamArray().length; i++) {
            if (team.getTeamArray()[i] != null) {
                System.out.println(team.getTeamArray()[i] + " passed the obstacle course!");
            }
        }
    }

    public void doIt(Team team) {
        System.out.println("Get started");
        crossWall(team);
        crossRiver(team);
        System.out.println("Final");
        resultCourse(team);
    }
}
