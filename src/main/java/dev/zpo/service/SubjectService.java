// SubjectService.java
package dev.zpo.service;

import dev.zpo.entity.Subject;
import dev.zpo.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectBySubjectId(Long subjectId) {
        return subjectRepository.findBySubjectId(subjectId);
    }

    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Transactional
    public void deleteSubjectBySubjectId(Long subjectId) {
        subjectRepository.deleteBySubjectId(subjectId);
    }
}
