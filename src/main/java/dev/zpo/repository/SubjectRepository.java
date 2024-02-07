// SubjectRepository.java
package dev.zpo.repository;

import dev.zpo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectId(Long subjectId);
    void deleteBySubjectId(Long subjectId);
}
