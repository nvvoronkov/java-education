package lesson.streams;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static List<Course> getUniqueCourses(final List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .toList();
    }

    public static List<Student> getMostCurious(final List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(student -> student.getAllCourses().size()))
                .limit(3)
                .toList();
    }

    public static List<Student> getStudentsByCourse(final List<Student> students, final Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .toList();
    }
}
