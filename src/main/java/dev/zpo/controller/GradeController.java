package dev.zpo.controller;

import dev.zpo.entity.Grade;
import dev.zpo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing grades.
 * Handles HTTP requests related to grades, such as adding, deleting, and updating grades.
 * Provides RESTful API endpoints for interacting with grade data.
 *
 * <p>Endpoints:
 * <ul>
 *     <li>POST /api/grades/add: Add a new grade</li>
 *     <li>DELETE /api/grades/{subjectId}: Delete all grades associated with a subject</li>
 *     <li>DELETE /api/grades/std/{studentId}: Delete all grades associated with a student</li>
 *     <li>PUT /api/grades/grade-update/{gradeId}: Update a grade by its ID</li>
 * </ul>
 *
 * <p>This controller class is responsible for managing CRUD operations for grades.
 * It interacts with the GradeService to perform business logic and data manipulation.
 * It also handles HTTP requests and responses, mapping incoming requests to appropriate service methods
 * and returning responses with appropriate status codes.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "http://localhost:3000")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    /**
     * Add a new grade.
     *
     * @param grade The grade object to be added.
     * @return ResponseEntity containing the added grade and HTTP status code 201 (Created) if successful,
     *         or an HTTP status code indicating failure.
     */
    @PostMapping("/add")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade) {
        Grade addedGrade = gradeService.addGrade(grade);
        return new ResponseEntity<>(addedGrade, HttpStatus.CREATED);
    }

    /**
     * Delete all grades associated with a subject.
     *
     * @param subjectId The ID of the subject whose grades are to be deleted.
     * @return ResponseEntity with HTTP status code 204 (No Content) if successful,
     *         or an HTTP status code indicating failure.
     */
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteGradesBySubjectId(@PathVariable Long subjectId) {
        gradeService.deleteGradesBySubjectId(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all grades associated with a student.
     *
     * @param studentId The ID of the student whose grades are to be deleted.
     * @return ResponseEntity with HTTP status code 204 (No Content) if successful,
     *         or an HTTP status code indicating failure.
     */
    @DeleteMapping("/std/{studentId}")
    public ResponseEntity<Void> deleteGradesByStudentId(@PathVariable Long studentId) {
        gradeService.deleteGradesByStudentId(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Update a grade by its ID.
     *
     * @param gradeId The ID of the grade to be updated.
     * @param grade   The updated grade value.
     * @return ResponseEntity with HTTP status code 204 (No Content) if successful,
     *         or HTTP status code 404 (Not Found) if the grade with the specified ID is not found.
     */
    @PutMapping("/grade-update/{gradeId}")
    public ResponseEntity<Void> updateGradeById(@PathVariable Long gradeId, @RequestBody String grade) {
        int rowsAffected = gradeService.updateGradeById(gradeId, grade);
        if (rowsAffected > 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

