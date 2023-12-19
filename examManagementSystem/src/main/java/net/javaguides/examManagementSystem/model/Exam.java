package net.javaguides.examManagementSystem.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String subjectName;
    private int totalQuestions;
    private int passMarks;
    private int marks;
    private String description;
    private Date examDate;

    // Constructors
    public Exam() {
    }

    public Exam(String code, String subjectName, int totalQuestions, int passMarks, int marks, String description, Date examDate) {
        this.code = code;
        this.subjectName = subjectName;
        this.totalQuestions = totalQuestions;
        this.passMarks = passMarks;
        this.marks = marks;
        this.description = description;
        this.examDate = examDate;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(int passMarks) {
        this.passMarks = passMarks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    // Other methods
    // ...
}
