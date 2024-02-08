package dev.zpo.entity;

import jakarta.persistence.*;

/**
 * Entity class representing a grade.
 * This class maps to the "grades" table in the database and contains information about a student's grade in a subject.
 * Each grade has an ID, student ID, subject ID, and grade value.
 *
 * <p>The grade entity is mapped to a database table using JPA annotations.
 * It includes fields for the grade ID, student ID, subject ID, and grade value.
 * This class provides getters and setters for accessing and modifying its fields.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "grade")
    private Double grade;

    /**
     * Default constructor.
     * Constructs a new Grade object with default values.
     */
    public Grade() {}

    /**
     * Get the ID of the grade.
     *
     * @return The ID of the grade.
     */
    public Long getId() {
        return id;
    }

    /**
     * Get the student ID associated with the grade.
     *
     * @return The student ID associated with the grade.
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * Get the subject ID associated with the grade.
     *
     * @return The subject ID associated with the grade.
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * Get the grade value.
     *
     * @return The grade value.
     */
    public Double getGrade() {
        return grade;
    }

    /**
     * Set the ID of the grade.
     *
     * @param id The ID of the grade to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the student ID associated with the grade.
     *
     * @param studentId The student ID to set.
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Set the subject ID associated with the grade.
     *
     * @param subjectId The subject ID to set.
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Set the grade value.
     *
     * @param grade The grade value to set.
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }
}

