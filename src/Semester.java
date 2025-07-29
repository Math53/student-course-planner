package src;

import java.util.ArrayList;
import java.util.List;

public class Semester {
    private String term;                // e.g. “Fall 2025”
    private List<Course> courses;

    public Semester(String term) {
        this.term = term;
        this.courses = new ArrayList<>();
    }

    /* ---------- Basic getters ---------- */

    public String getTerm() {
        return term;
    }

    public List<Course> getCourses() {
        return courses;
    }

    /* ---------- Core functionality ---------- */

    public void addCourse(Course c) {
        courses.add(c);
    }

    public boolean removeCourse(String code) {
        return courses.removeIf(c -> c.getCode().equalsIgnoreCase(code));
    }

    public int getTotalCredits() {
        return courses.stream()
                      .mapToInt(Course::getCredits)
                      .sum();
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses added for " + term);
        } else {
            System.out.println("Courses for " + term + ":");
            courses.forEach(c -> System.out.println("  • " + c));
            System.out.println("Total credits: " + getTotalCredits());
        }
    }
}

