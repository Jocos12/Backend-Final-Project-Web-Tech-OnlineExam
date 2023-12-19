package net.javaguides.examManagementSystem.repository;

import net.javaguides.examManagementSystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // You can add custom queries or methods if needed
}
