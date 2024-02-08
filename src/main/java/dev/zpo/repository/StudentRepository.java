package dev.zpo.repository;
import dev.zpo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and managing Student entities in the database.
 * This interface extends the JpaRepository interface, providing basic CRUD operations
 * for Student entities out of the box.
 *
 * <p>The repository is responsible for managing interactions between the application and the database.
 * It includes a custom method for deleting students by their ID.
 *
 * @author Ronald Frangulyan
 * @version 1.0
 * @since 2024-02-08
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    /**
     * Delete a student by their ID.
     *
     * @param studentId The ID of the student to be deleted.
     */
    void deleteByStudentId(Long studentId);
}
