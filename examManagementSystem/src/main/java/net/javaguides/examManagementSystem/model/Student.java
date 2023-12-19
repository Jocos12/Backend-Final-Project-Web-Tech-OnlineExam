package net.javaguides.examManagementSystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student") // Change table name to "students"
public class Student {
    @Id
    private long id; // Removed @GeneratedValue

    @Column(name = "first_name") // Change column name to "first_name"
    private String firstName;

    @Column(name = "last_name") // Change column name to "last_name"
    private String lastName;

    @Column(name = "email_id") // Change column name to "email_id"
    private String emailId;

    @Column(name = "semester") // New attribute "number"
    private String number;

    @Column(name = "department") // New attribute "department"
    private String department;

    @Column(name = "faculty") // New attribute "faculty"
    private String faculty;

    @Column(name = "password") // New attribute "password"
    private String password;

    @Column(name = "phone_number") // New attribute "phone_number"
    private String phoneNumber;
}