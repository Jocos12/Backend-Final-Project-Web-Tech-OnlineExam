package net.javaguides.examManagementSystem.controller;

import net.javaguides.examManagementSystem.Exception.ResourceNotFoundException;
import net.javaguides.examManagementSystem.model.Question;
import net.javaguides.examManagementSystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // build create question REST API
    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    // build get question by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not exist with id:" + id));
        return ResponseEntity.ok(question);
    }

    // build update question REST API
    @PutMapping("{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable long id, @RequestBody Question questionDetails) {
        Question updateQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not exist with id: " + id));

        updateQuestion.setCode(questionDetails.getCode());
        updateQuestion.setSubjectName(questionDetails.getSubjectName());
        updateQuestion.setAnswer(questionDetails.getAnswer());
        updateQuestion.setOptionOne(questionDetails.getOptionOne());
        updateQuestion.setOptionTwo(questionDetails.getOptionTwo());
        updateQuestion.setOptionThree(questionDetails.getOptionThree());
        updateQuestion.setOptionFour(questionDetails.getOptionFour());
        updateQuestion.setQuestion(questionDetails.getQuestion());

        questionRepository.save(updateQuestion);

        return ResponseEntity.ok(updateQuestion);
    }

    // build delete question REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable long id) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not exist with id: " + id));

        questionRepository.delete(question);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
