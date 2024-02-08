package dev.zpo.entity;

import jakarta.persistence.*;

/**
 * Entity class representing a student.
 * This class maps to the "students" table in the database and contains information about a student's details.
 * Each student has an ID, student ID, student name, and student surname.
 *
 * <p>The student entity is mapped to a database table using JPA annotations.
 * It includes fields for the student ID, student name, and student surname.
 * This class provides getters and setters for accessing and modifying its fields.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_surname")
    private String studentSurname;

    @Column(name = "student_id")
    private Long studentId;

    /**
     * Default constructor.
     * Constructs a new Student object with default values.
     */
    public Student() {}

    /**
     * Get the ID of the student.
     *
     * @return The ID of the student.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the student.
     *
     * @param id The ID of the student to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the student ID.
     *
     * @return The student ID.
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * Set the student ID.
     *
     * @param studentId The student ID to set.
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Get the student's name.
     *
     * @return The student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Set the student's name.
     *
     * @param studentName The student's name to set.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get the student's surname.
     *
     * @return The student's surname.
     */
    public String getStudentSurname() {
        return studentSurname;
    }

    /**
     * Set the student's surname.
     *
     * @param studentSurname The student's surname to set.
     */
    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }
}
