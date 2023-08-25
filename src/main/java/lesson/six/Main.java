package lesson.six;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    public List<Course> getUniqueCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .toList();
    }

    public List<Student> getMostCurious(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(student -> student.getAllCourses().size()))
                .limit(3)
                .toList();
    }

    public List<Student> getStudentsByCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .toList();
    }
}
