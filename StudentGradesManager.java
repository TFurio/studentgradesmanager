import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradesManager {

    // Create a HashMap to store student names and their list of grades
    private HashMap<String, ArrayList<Integer>> studentGrades;

    // Constructor to initialize the student grades map
    public StudentGradesManager() {
        studentGrades = new HashMap<>();
    }

    // Add a new grade for a student
    public void addGrade(String studentName, int grade) {
        if (!studentGrades.containsKey(studentName)) {
            studentGrades.put(studentName, new ArrayList<>());
        }
        studentGrades.get(studentName).add(grade);
    }

    // Calculate the average grade for a student
    public double calculateAverage(String studentName) {
        if (!studentGrades.containsKey(studentName)) {
            System.out.println("Student not found.");
            return 0;
        }
        ArrayList<Integer> grades = studentGrades.get(studentName);
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }

    // Display all students and their average grades
    public void displayStudents() {
        if (studentGrades.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (String student : studentGrades.keySet()) {
            System.out.println("Student: " + student + ", Average Grade: " + calculateAverage(student));
        }
    }

    public static void main(String[] args) {
        StudentGradesManager manager = new StudentGradesManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a grade for a student");
            System.out.println("2. Display all students and their average grades");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    manager.addGrade(studentName, grade);
                    System.out.println("Grade added.");
                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        scanner.close();
    }
}