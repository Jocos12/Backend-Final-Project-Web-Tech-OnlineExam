package net.javaguides.examManagementSystem.controller;

import net.javaguides.examManagementSystem.Exception.ResourceNotFoundException;
import net.javaguides.examManagementSystem.model.Student;
import net.javaguides.examManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentRepository.save(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails) {
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        // Update existing attributes
        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmailId(studentDetails.getEmailId());

        // Set new attributes
        updateStudent.setPassword(studentDetails.getPassword());
        updateStudent.setNumber(studentDetails.getNumber());
        updateStudent.setDepartment(studentDetails.getDepartment());
        updateStudent.setFaculty(studentDetails.getFaculty());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id: " + id));

        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();

            // Check if the provided password matches the stored password
            if (existingStudent.getPassword().equals(student.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            throw new ResourceNotFoundException("Student not exist with id:" + student.getId());
        }
    }
}
