package net.javaguides.examManagementSystem.service;

import net.javaguides.examManagementSystem.model.Result;
import net.javaguides.examManagementSystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result getResultById(Long id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        return optionalResult.orElse(null);
    }

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public Result updateResult(Long id, Result result) {
        if (resultRepository.existsById(id)) {
            result.setId(id);
            return resultRepository.save(result);
        }
        return null; // Le résultat avec l'ID spécifié n'existe pas
    }

    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}

