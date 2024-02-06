package dev.zpo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name")
    private String subjectName;

}