package dev.zpo.controller;

import dev.zpo.entity.Grade;
import dev.zpo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "http://localhost:3000")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/add")
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade) {
        Grade addedGrade = gradeService.addGrade(grade);
        return new ResponseEntity<>(addedGrade, HttpStatus.CREATED);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteGradesBySubjectId(@PathVariable Long subjectId) {
        gradeService.deleteGradesBySubjectId(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/std/{studentId}")
    public ResponseEntity<Void> deleteGradesByStudentId(@PathVariable Long studentId) {
        gradeService.deleteGradesByStudentId(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
