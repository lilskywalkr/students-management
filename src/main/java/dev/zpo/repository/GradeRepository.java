package dev.zpo.repository;

import dev.zpo.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing Grade entities in the database.
 * This interface provides methods for CRUD operations on Grade entities,
 * including adding, deleting, updating, and retrieving grades.
 *
 * <p>The repository is responsible for managing interactions between the application and the database.
 * It extends the JpaRepository interface, providing basic CRUD operations out of the box.
 * Additionally, it includes custom query methods for specific database operations.
 *
 * <p>Transactional annotations are used to ensure that operations performed by repository methods
 * are executed within a transactional context.
 *
 * <p>The repository also includes methods for deleting grades by subject ID or student ID,
 * as well as a method for updating a grade's value by its ID.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    /**
     * Delete grades associated with a specific subject.
     *
     * @param subjectId The ID of the subject whose grades are to be deleted.
     */
    @Transactional
    void deleteBySubjectId(Long subjectId);

    /**
     * Delete grades associated with a specific student.
     *
     * @param studentId The ID of the student whose grades are to be deleted.
     */
    @Transactional
    void deleteByStudentId(Long studentId);

    /**
     * Update the value of a grade with a specific ID.
     *
     * @param gradeId The ID of the grade to be updated.
     * @param grade   The new value of the grade.
     * @return The number of affected rows in the database.
     */
    @Transactional
    @Modifying
    @Query("UPDATE Grade g SET g.grade = :grade WHERE g.id = :gradeId")
    int updateGradeById(@Param("gradeId") Long gradeId, @Param("grade") String grade);
}

