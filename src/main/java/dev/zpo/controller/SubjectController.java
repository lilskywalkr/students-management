// SubjectController.java
package dev.zpo.controller;

import dev.zpo.entity.Subject;
import dev.zpo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful API Controller for managing subjects.
 * This controller provides endpoints for adding, deleting, and retrieving subject information,
 * as well as retrieving subjects with grades for a student and average grades for subjects.
 *
 * <p>Endpoints:
 * <ul>
 *     <li>GET /api/subjects/get: Get all subjects</li>
 *     <li>GET /api/subjects/{subjectId}: Get a subject by ID</li>
 *     <li>POST /api/subjects/add: Add a new subject</li>
 *     <li>DELETE /api/subjects/{subjectId}: Delete a subject by ID</li>
 *     <li>GET /api/subjects/sbj/{studentId}: Get subjects with grades for a student</li>
 *     <li>GET /api/subjects/average-grades: Get subjects with average grades</li>
 * </ul>
 *
 * <p>This controller handles HTTP requests related to subjects and delegates the processing to the SubjectService.
 * It follows REST principles to map HTTP methods and URIs to corresponding service methods.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * Get all subjects.
     *
     * @return ResponseEntity containing a list of all subjects and HTTP status code 200 (OK).
     */
    @GetMapping("/get")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    /**
     * Get a subject by ID.
     *
     * @param subjectId The ID of the subject to retrieve.
     * @return ResponseEntity containing the requested subject and HTTP status code 200 (OK) if found,
     *         or an HTTP status code indicating failure.
     */
    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectBySubjectId(@PathVariable Long subjectId) {
        Subject subject = subjectService.getSubjectBySubjectId(subjectId);
        if (subject != null) {
            return new ResponseEntity<>(subject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Add a new subject.
     *
     * @param subject The subject object to be added.
     * @return ResponseEntity containing the added subject and HTTP status code 201 (Created) if successful,
     *         or an HTTP status code indicating failure.
     */
    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        Subject addedSubject = subjectService.addSubject(subject);
        return new ResponseEntity<>(addedSubject, HttpStatus.CREATED);
    }

    /**
     * Delete a subject by ID.
     *
     * @param subjectId The ID of the subject to be deleted.
     * @return ResponseEntity with HTTP status code 204 (No Content) if successful,
     *         or an HTTP status code indicating failure.
     */
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubjectBySubjectId(@PathVariable Long subjectId) {
        subjectService.deleteSubjectBySubjectId(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Get subjects with grades for a student.
     *
     * @param studentId The ID of the student to retrieve subjects and grades for.
     * @return ResponseEntity containing a list of objects representing subjects and grades,
     *         along with HTTP status code 200 (OK).
     */
    @GetMapping("/sbj/{studentId}")
    public ResponseEntity<List<Object[]>> getSubjectsAndGradesForStudent(@PathVariable Long studentId) {
        List<Object[]> subjectsAndGrades = subjectService.getSubjectsAndGradesForStudent(studentId);
        return new ResponseEntity<>(subjectsAndGrades, HttpStatus.OK);
    }

    /**
     * Get subjects with average grades.
     *
     * @return ResponseEntity containing a list of objects representing subjects and average grades,
     *         along with HTTP status code 200 (OK).
     */
    @GetMapping("/average-grades")
    public ResponseEntity<List<Object[]>> getSubjectsAndAverageGrades() {
        List<Object[]> subjectsAndAverageGrades = subjectService.getSubjectsAndAverageGrades();
        return new ResponseEntity<>(subjectsAndAverageGrades, HttpStatus.OK);
    }
}
