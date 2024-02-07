// SubjectRepository.java
package dev.zpo.repository;

import dev.zpo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectId(Long subjectId);
    void deleteBySubjectId(Long subjectId);

    @Query("SELECT s.subjectName, g.grade FROM Subject s JOIN Grade g ON s.subjectId = g.subjectId WHERE g.studentId = :studentId")
    List<Object[]> findSubjectsAndGradesForStudent(@Param("studentId") Long studentId);

    @Query("SELECT s.subjectName, AVG(g.grade) FROM Subject s JOIN Grade g ON s.subjectId = g.subjectId GROUP BY s.subjectName")
    List<Object[]> findSubjectsAndAverageGrades();

}
