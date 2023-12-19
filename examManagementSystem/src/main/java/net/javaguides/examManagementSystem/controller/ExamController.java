package net.javaguides.examManagementSystem.controller;


import net.javaguides.examManagementSystem.Exception.ResourceNotFoundException;
import net.javaguides.examManagementSystem.model.Exam;
import net.javaguides.examManagementSystem.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping
    public List<Exam> getAllExams(){
        return examRepository.findAll();
    }

    // build create exam REST API
    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    // build get exam by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable long id){
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id:" + id));
        return ResponseEntity.ok(exam);
    }

    // build update exam REST API
    @PutMapping("{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable long id, @RequestBody Exam examDetails) {
        Exam updateExam = examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));

        updateExam.setCode(examDetails.getCode());
        updateExam.setSubjectName(examDetails.getSubjectName());
        updateExam.setTotalQuestions(examDetails.getTotalQuestions());
        updateExam.setPassMarks(examDetails.getPassMarks());
        updateExam.setMarks(examDetails.getMarks());
        updateExam.setDescription(examDetails.getDescription());
        updateExam.setExamDate(examDetails.getExamDate());

        examRepository.save(updateExam);

        return ResponseEntity.ok(updateExam);
    }

    // build delete exam REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteExam(@PathVariable long id){

        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not exist with id: " + id));

        examRepository.delete(exam);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
