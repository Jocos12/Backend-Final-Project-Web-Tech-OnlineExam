package net.javaguides.examManagementSystem.repository;

import net.javaguides.examManagementSystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}
