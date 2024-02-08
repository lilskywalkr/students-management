// SubjectService.java
package dev.zpo.service;

import dev.zpo.entity.Subject;
import dev.zpo.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class for managing Subject entities.
 * This service provides methods for retrieving, adding, and deleting subjects in the database.
 * It also provides methods for fetching subjects along with their corresponding grades and calculating average grades.
 *
 * <p>The service interacts with the SubjectRepository to perform database operations.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Service
public class SubjectService {

    /**
     * Repository interface for accessing and managing Subject entities.
     */
    @Autowired
    private SubjectRepository subjectRepository;

    /**
     * Retrieve all subjects from the database.
     *
     * @return A list of all subjects.
     */
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    /**
     * Retrieve a subject from the database by its ID.
     *
     * @param subjectId The ID of the subject to retrieve.
     * @return The subject with the specified ID, or null if not found.
     */
    public Subject getSubjectBySubjectId(Long subjectId) {
        return subjectRepository.findBySubjectId(subjectId);
    }

    /**
     * Add a new subject to the database.
     *
     * @param subject The subject to be added.
     * @return The added subject.
     */
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    /**
     * Delete a subject from the database by its ID.
     *
     * @param subjectId The ID of the subject to delete.
     */
    @Transactional
    public void deleteSubjectBySubjectId(Long subjectId) {
        subjectRepository.deleteBySubjectId(subjectId);
    }

    /**
     * Retrieve subjects along with their corresponding grades for a given student ID.
     *
     * @param studentId The ID of the student.
     * @return A list of Object arrays containing subject and grade information for the student.
     */
    public List<Object[]> getSubjectsAndGradesForStudent(Long studentId) {
        return subjectRepository.findSubjectsAndGradesForStudent(studentId);
    }

    /**
     * Retrieve subjects along with their average grades.
     *
     * @return A list of Object arrays containing subject and average grade information.
     */
    public List<Object[]> getSubjectsAndAverageGrades() {
        return subjectRepository.findSubjectsAndAverageGrades();
    }
}

