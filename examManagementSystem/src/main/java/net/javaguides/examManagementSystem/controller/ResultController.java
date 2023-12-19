package net.javaguides.examManagementSystem.controller;

import net.javaguides.examManagementSystem.Exception.ResourceNotFoundException;
import net.javaguides.examManagementSystem.model.Result;

import net.javaguides.examManagementSystem.repository.QuestionRepository;
import net.javaguides.examManagementSystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/results")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private QuestionRepository questionRepository;

    // Endpoint to submit user information before starting the exam
    @PostMapping("/user-info")
    public ResponseEntity<String> submitUserInfo(@RequestBody Result result) {
        // Validate the input (you can add more validation logic)
        if (result.getUserEmail() == null || result.getCode() == null) {
            return new ResponseEntity<>("Invalid user information", HttpStatus.BAD_REQUEST);
        }

        // Save the user information directly in the Result table
        resultRepository.save(result);

        return new ResponseEntity<>("User information submitted successfully", HttpStatus.OK);
    }


    // Endpoint to create result after the exam
    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        // Validate the input (you can add more validation logic)
        if (result.getUserEmail() == null || result.getCode() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Add your logic to calculate the result status
        int passScore = 20;
        result.setResultStatus(result.getResultScore() >= passScore ? "Pass" : "Fail");

        // Save the result
        Result savedResult = resultRepository.save(result);

        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }

    // build get result by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Result> getResultById(@PathVariable long id) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not exist with id:" + id));
        return ResponseEntity.ok(result);
    }

    // build update result REST API
    @PutMapping("{id}")
    public ResponseEntity<Result> updateResult(@PathVariable long id, @RequestBody Result resultDetails) {
        Result updateResult = resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not exist with id: " + id));

        updateResult.setCode(resultDetails.getCode());
        updateResult.setSubjectName(resultDetails.getSubjectName());
        updateResult.setResultScore(resultDetails.getResultScore());
        updateResult.setResultStatus(resultDetails.getResultStatus());
        updateResult.setUserEmail(resultDetails.getUserEmail());
        updateResult.setMarks(resultDetails.getMarks());

        // Vous pouvez inclure ici la logique de mise à jour du statut si nécessaire

        resultRepository.save(updateResult);

        return ResponseEntity.ok(updateResult);
    }

    // build delete result REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteResult(@PathVariable long id) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not exist with id: " + id));

        resultRepository.delete(result);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
