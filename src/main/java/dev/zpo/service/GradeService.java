package dev.zpo.service;

import dev.zpo.entity.Grade;
import dev.zpo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public Grade addGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGradesBySubjectId(Long subjectId) {
        gradeRepository.deleteBySubjectId(subjectId);
    }

    public void deleteGradesByStudentId(Long studentId) {
        gradeRepository.deleteByStudentId(studentId);
    }
}
