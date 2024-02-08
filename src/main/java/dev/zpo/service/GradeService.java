package dev.zpo.service;

import dev.zpo.entity.Grade;
import dev.zpo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Grade entities.
 * This service provides methods for adding, deleting, and updating grades in the database.
 *
 * <p>The service interacts with the GradeRepository to perform database operations.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Service
public class GradeService {

    /**
     * Repository interface for accessing and managing Grade entities.
     */
    @Autowired
    private GradeRepository gradeRepository;

    /**
     * Add a new grade to the database.
     *
     * @param grade The grade to be added.
     * @return The added grade.
     */
    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    /**
     * Delete all grades associated with a specific subject from the database.
     *
     * @param subjectId The ID of the subject whose grades are to be deleted.
     */
    public void deleteGradesBySubjectId(Long subjectId) {
        gradeRepository.deleteBySubjectId(subjectId);
    }

    /**
     * Delete all grades associated with a specific student from the database.
     *
     * @param studentId The ID of the student whose grades are to be deleted.
     */
    public void deleteGradesByStudentId(Long studentId) {
        gradeRepository.deleteByStudentId(studentId);
    }

    /**
     * Update the grade of a specific grade entity in the database.
     *
     * @param gradeId The ID of the grade to be updated.
     * @param grade   The new grade value.
     * @return The number of rows affected by the update operation.
     */
    public int updateGradeById(Long gradeId, String grade) {
        return gradeRepository.updateGradeById(gradeId, grade);
    }
}

