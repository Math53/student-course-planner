package src;

import java.util.Scanner;

public class PlannerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Semester semester = FileManager.loadSemester();

        System.out.println("Welcome to the Student Course Planner");
        System.out.println("Current term: " + semester.getTerm());

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add course");
            System.out.println("2. Remove course");
            System.out.println("3. View courses");
            System.out.println("4. Save planner");
            System.out.println("5. Quit");

            System.out.print("Choose an option (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Course name: ");
                    String name = scanner.nextLine();
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();
                    System.out.print("Credits: ");
                    int credits = Integer.parseInt(scanner.nextLine());
                    System.out.print("Day/Time (e.g., MWF 10:00-11:00): ");
                    String dayTime = scanner.nextLine();

                    Course course = new Course(name, code, credits, dayTime);
                    semester.addCourse(course);
                    System.out.println("Course added.");
                }
                case "2" -> {
                    System.out.print("Enter course code to remove: ");
                    String code = scanner.nextLine();
                    boolean removed = semester.removeCourse(code);
                    System.out.println(removed ? "Course removed." : "Course not found.");
                }
                case "3" -> semester.listCourses();
                case "4" -> FileManager.saveSemester(semester);
                case "5" -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

