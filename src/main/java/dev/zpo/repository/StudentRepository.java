package dev.zpo.repository;
import dev.zpo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteByStudentId(Long studentId);
}
