package net.javaguides.examManagementSystem.service;

import net.javaguides.examManagementSystem.model.Exam;
import net.javaguides.examManagementSystem.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        return optionalExam.orElse(null);
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam updateExam(Long id, Exam exam) {
        if (examRepository.existsById(id)) {
            exam.setId(id);
            return examRepository.save(exam);
        }
        return null; // L'examen avec l'ID spécifié n'existe pas
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
