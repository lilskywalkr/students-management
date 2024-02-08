package dev.zpo.repository;

import dev.zpo.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Transactional
    void deleteBySubjectId(Long subjectId);

    @Transactional
    void deleteByStudentId(Long studentId);

    @Transactional
    @Modifying
    @Query("UPDATE Grade g SET g.grade = :grade WHERE g.id = :gradeId")
    int updateGradeById(@Param("gradeId") Long gradeId, @Param("grade") String grade);
}
