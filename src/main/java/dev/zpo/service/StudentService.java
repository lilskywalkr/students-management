package dev.zpo.service;
import dev.zpo.entity.Student;
import dev.zpo.repository.StudentRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudentByStudentId(Long studentId) {
        studentRepository.deleteByStudentId(studentId);
    }
}
