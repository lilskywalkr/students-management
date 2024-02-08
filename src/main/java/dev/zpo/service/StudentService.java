package dev.zpo.service;
import dev.zpo.entity.Student;
import dev.zpo.repository.StudentRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Student entities.
 * This service provides methods for adding and deleting students in the database.
 *
 * <p>The service interacts with the StudentRepository to perform database operations.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
@Service
public class StudentService {

    /**
     * Repository interface for accessing and managing Student entities.
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Add a new student to the database.
     *
     * @param student The student to be added.
     * @return The added student.
     */
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Delete a student from the database by their ID.
     *
     * @param studentId The ID of the student to be deleted.
     */
    @Transactional
    public void deleteStudentByStudentId(Long studentId) {
        studentRepository.deleteByStudentId(studentId);
    }
}
