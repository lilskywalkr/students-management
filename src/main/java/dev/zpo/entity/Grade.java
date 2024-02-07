package dev.zpo.entity;

import jakarta.persistence.*;

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
    private String grade;

    public Grade() {}

    // Getters
    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
