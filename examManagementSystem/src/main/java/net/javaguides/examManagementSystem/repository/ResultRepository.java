package net.javaguides.examManagementSystem.repository;

import net.javaguides.examManagementSystem.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
}

