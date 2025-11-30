package org.example.manager;

import org.example.exception.EnrollmentException;
import org.example.model.Course;
import org.example.model.Student;

import java.util.HashMap;

public class EnrollmentManager {

    // Master database
    private HashMap<Integer, Student> studentDatabase = new HashMap<>();

    // Add student
    public void addStudent(Student student) {
        studentDatabase.put(student.getStudentId(), student);
    }

    // Enroll student in a course
    public void enrollCourse(int studentId, Course course) throws EnrollmentException {
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        if (course.getCurrentEnrollment() >= course.getMaxCapacity()) {
            throw new EnrollmentException("Course is full.");
        }

        student.getCoursesEnrolled().add(course);
        course.setCurrentEnrollment(course.getCurrentEnrollment() + 1);
        System.out.println(student.getStudentName() + " enrolled in " + course.getCourseName());
    }

    // Display student report
    public void displayStudentReport(int studentId) {
        Student student = studentDatabase.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\n--- Student Report ---");
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Enrolled Courses:");
        for (Course course : student.getCoursesEnrolled()) {
            System.out.println("- " + course.getCourseName());
        }
        System.out.println("----------------------\n");
    }

    // Input validation for grades
    public int getGradeFromInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid grade input! Please enter a numeric value.");
            return -1; // sentinel value
        }
    }
}
