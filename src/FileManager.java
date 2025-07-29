package src;

import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "planner.txt";

    public static void saveSemester(Semester semester) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(semester.getTerm());
            for (Course course : semester.getCourses()) {
                writer.println(course.getName() + "|" + course.getCode() + "|" + course.getCredits() + "|" + course.getDayTime());
            }
            System.out.println("Planner saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving planner: " + e.getMessage());
        }
    }

    public static Semester loadSemester() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved planner found. Starting fresh.");
            return new Semester("Untitled Semester");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String term = reader.readLine();
            Semester semester = new Semester(term);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String name = parts[0];
                    String code = parts[1];
                    int credits = Integer.parseInt(parts[2]);
                    String time = parts[3];
                    Course course = new Course(name, code, credits, time);
                    semester.addCourse(course);
                }
            }

            System.out.println("Planner loaded from " + FILE_NAME);
            return semester;

        } catch (IOException e) {
            System.out.println("Error loading planner: " + e.getMessage());
            return new Semester("Untitled Semester");
        }
    }
}

