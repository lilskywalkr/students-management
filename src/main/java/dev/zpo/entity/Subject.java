package dev.zpo.entity;
import jakarta.persistence.*;

/**
 * Entity class representing a subject.
 * This class maps to the "subjects" table in the database and contains information about a subject.
 * Each subject has an ID, subject ID, and subject name.
 *
 * <p>The subject entity is mapped to a database table using JPA annotations.
 * It includes fields for the subject ID and subject name.
 * This class provides getters and setters for accessing and modifying its fields.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    /**
     * Default constructor.
     * Constructs a new Subject object with default values.
     */
    public Subject() {}

    /**
     * Get the ID of the subject.
     *
     * @return The ID of the subject.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the subject.
     *
     * @param id The ID of the subject to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the subject ID.
     *
     * @return The subject ID.
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * Set the subject ID.
     *
     * @param subjectId The subject ID to set.
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Get the subject's name.
     *
     * @return The subject's name.
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Set the subject's name.
     *
     * @param subjectName The subject's name to set.
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
