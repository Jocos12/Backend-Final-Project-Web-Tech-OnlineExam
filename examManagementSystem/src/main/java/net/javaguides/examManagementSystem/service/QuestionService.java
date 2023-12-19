package net.javaguides.examManagementSystem.service;

import net.javaguides.examManagementSystem.model.Question;
import net.javaguides.examManagementSystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion.orElse(null);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question question) {
        if (questionRepository.existsById(id)) {
            question.setId(id);
            return questionRepository.save(question);
        }
        return null; // La question avec l'ID spécifié n'existe pas
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
