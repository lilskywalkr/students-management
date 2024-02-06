package dev.zpo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long gradeId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "grade")
    private String grade;

    // Getters and setters
    // You may also want to add constructors and other methods
}