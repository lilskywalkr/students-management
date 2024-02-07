// SubjectController.java
package dev.zpo.controller;

import dev.zpo.entity.Subject;
import dev.zpo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/get")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectBySubjectId(@PathVariable Long subjectId) {
        Subject subject = subjectService.getSubjectBySubjectId(subjectId);
        if (subject != null) {
            return new ResponseEntity<>(subject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        Subject addedSubject = subjectService.addSubject(subject);
        return new ResponseEntity<>(addedSubject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubjectBySubjectId(@PathVariable Long subjectId) {
        subjectService.deleteSubjectBySubjectId(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/sbj/{studentId}")
    public ResponseEntity<List<Object[]>> getSubjectsAndGradesForStudent(@PathVariable Long studentId) {
        List<Object[]> subjectsAndGrades = subjectService.getSubjectsAndGradesForStudent(studentId);
        return new ResponseEntity<>(subjectsAndGrades, HttpStatus.OK);
    }

    @GetMapping("/average-grades")
    public ResponseEntity<List<Object[]>> getSubjectsAndAverageGrades() {
        List<Object[]> subjectsAndAverageGrades = subjectService.getSubjectsAndAverageGrades();
        return new ResponseEntity<>(subjectsAndAverageGrades, HttpStatus.OK);
    }
}
