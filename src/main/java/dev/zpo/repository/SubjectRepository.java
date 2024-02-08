// SubjectRepository.java
package dev.zpo.repository;

import dev.zpo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing and managing Subject entities in the database.
 * This interface extends the JpaRepository interface, providing basic CRUD operations
 * for Subject entities out of the box.
 *
 * <p>The repository is responsible for managing interactions between the application and the database.
 * It includes custom methods for finding subjects by ID, deleting subjects by ID, and executing custom
 * queries to retrieve subjects and their associated grades.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    /**
     * Find a subject by its ID.
     *
     * @param subjectId The ID of the subject to find.
     * @return The subject with the specified ID, or null if not found.
     */
    Subject findBySubjectId(Long subjectId);

    /**
     * Delete a subject by its ID.
     *
     * @param subjectId The ID of the subject to delete.
     */
    void deleteBySubjectId(Long subjectId);

    /**
     * Retrieve a list of subjects along with their grades for a given student.
     *
     * @param studentId The ID of the student.
     * @return A list of arrays containing subject details and associated grades.
     */
    @Query("SELECT s.studentId, s.studentName, s.studentSurname, g.subjectId, sub.subjectName, g.grade, g.id " +
            "FROM Student s JOIN Grade g ON s.studentId = g.studentId JOIN Subject sub ON g.subjectId = sub.subjectId " +
            "WHERE s.studentId = :studentId")
    List<Object[]> findSubjectsAndGradesForStudent(@Param("studentId") Long studentId);

    /**
     * Retrieve a list of subjects along with their average grades.
     *
     * @return A list of arrays containing subject details and average grades.
     */
    @Query("SELECT s.subjectId, s.subjectName, AVG(g.grade) " +
            "FROM Subject s JOIN Grade g ON s.subjectId = g.subjectId " +
            "GROUP BY s.subjectName")
    List<Object[]> findSubjectsAndAverageGrades();
}

