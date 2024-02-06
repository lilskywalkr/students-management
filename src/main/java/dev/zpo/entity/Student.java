package dev.zpo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_surname")
    private String studentSurname;

    @Column(name = "subject_id")
    private Long subjectId; // This seems unusual, see note below

    // Getters and setters
    // You may also want to add constructors and other methods
}
