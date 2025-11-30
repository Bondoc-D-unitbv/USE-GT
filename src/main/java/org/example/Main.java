package org.example;

import org.example.exception.EnrollmentException;
import org.example.manager.EnrollmentManager;
import org.example.model.Course;
import org.example.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EnrollmentManager manager = new EnrollmentManager();

        // Create courses
        Course math = new Course("C101", "Mathematics", 2);
        Course physics = new Course("C102", "Physics", 1);

        // Create students
        Student alice = new Student(1, "Alice");
        Student bob = new Student(2, "Bob");

        // Add students to database
        manager.addStudent(alice);
        manager.addStudent(bob);

        // Successful enrollment
        try {
            manager.enrollCourse(1, math);
            manager.enrollCourse(2, math); // math has capacity 2
        } catch (EnrollmentException e) {
            System.out.println(e.getMessage());
        }

        // Attempt to over-enroll
        try {
            manager.enrollCourse(1, physics);
            manager.enrollCourse(2, physics); // physics capacity is 1, should throw
        } catch (EnrollmentException e) {
            System.out.println("Caught EnrollmentException: " + physics.getCourseName() + " " + e.getMessage());
        }

        // Display reports
        manager.displayStudentReport(1);
        manager.displayStudentReport(2);

        // Grade input demonstration
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grade for Alice: ");
        String gradeInput = scanner.nextLine();
        int grade = manager.getGradeFromInput(gradeInput);
        if (grade != -1) {
            System.out.println("Grade recorded: " + grade);
        }

        scanner.close();

    }
}