package dev.zpo.controller;

import dev.zpo.entity.Student;
import dev.zpo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful API Controller for managing students.
 * This controller provides endpoints for adding, deleting, and retrieving student information.
 *
 * <p>Endpoints:
 * <ul>
 *     <li>GET /api/students/hello: Get a welcome message</li>
 *     <li>POST /api/students/add: Add a new student</li>
 *     <li>DELETE /api/students/{studentId}: Delete a student by ID</li>
 * </ul>
 *
 * <p>This controller handles HTTP requests related to students and delegates the processing to the StudentService.
 * It follows REST principles to map HTTP methods and URIs to corresponding service methods.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Get a welcome message.
     *
     * @return A welcome message string.
     */
    @GetMapping("/hello")
    public String hello() {
        return "Student Management Application";
    }

    /**
     * Add a new student.
     *
     * @param student The student object to be added.
     * @return ResponseEntity containing the added student and HTTP status code 201 (Created) if successful,
     *         or an HTTP status code indicating failure.
     */
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    /**
     * Delete a student by ID.
     *
     * @param studentId The ID of the student to be deleted.
     * @return ResponseEntity with HTTP status code 204 (No Content) if successful,
     *         or an HTTP status code indicating failure.
     */
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentByStudentId(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
