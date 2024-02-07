package dev.zpo.repository;

import dev.zpo.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Transactional
    void deleteBySubjectId(Long subjectId);

    @Transactional
    void deleteByStudentId(Long studentId);
}
