package org.example.model;

import java.util.ArrayList;

public class Student {
    private Integer studentId;
    private String studentName;
    private ArrayList<Course> coursesEnrolled;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.coursesEnrolled = new ArrayList<>();
    }

    // Getters and Setters
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public ArrayList<Course> getCoursesEnrolled() { return coursesEnrolled; }
    public void setCoursesEnrolled(ArrayList<Course> coursesEnrolled) { this.coursesEnrolled = coursesEnrolled; }
}
