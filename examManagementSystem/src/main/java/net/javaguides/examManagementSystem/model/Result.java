package net.javaguides.examManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String subjectName;
    private int resultScore;
    private String resultStatus;
    private String userEmail;
    private int marks;

    // Constructors
    public Result() {
    }

    public Result(String code, String subjectName, int resultScore, String resultStatus, String userEmail, int marks) {
        this.code = code;
        this.subjectName = subjectName;
        this.resultScore = resultScore;
        this.resultStatus = resultStatus;
        this.userEmail = userEmail;
        this.marks = marks;
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

    public int getResultScore() {
        return resultScore;
    }

    public void setResultScore(int resultScore) {
        this.resultScore = resultScore;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Other methods
    // ...
}
