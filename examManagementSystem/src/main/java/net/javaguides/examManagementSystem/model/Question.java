package net.javaguides.examManagementSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String subjectName;
    private String answer;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private String question;

    // Constructors
    public Question() {
    }

    public Question(String code, String subjectName, String answer, String optionOne, String optionTwo, String optionThree, String optionFour, String question) {
        this.code = code;
        this.subjectName = subjectName;
        this.answer = answer;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.question = question;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // Other methods
    // ...
}
