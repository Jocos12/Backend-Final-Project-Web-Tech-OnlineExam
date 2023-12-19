package net.javaguides.examManagementSystem.repository;

import net.javaguides.examManagementSystem.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
