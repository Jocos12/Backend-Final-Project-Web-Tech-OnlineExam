package net.javaguides.examManagementSystem.controller;

import net.javaguides.examManagementSystem.Exception.ResourceNotFoundException;
import net.javaguides.examManagementSystem.model.Teacher;
import net.javaguides.examManagementSystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id:" + id));
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable long id, @RequestBody Teacher teacherDetails) {
        Teacher updateTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));

        // Update existing attributes
        updateTeacher.setFirstName(teacherDetails.getFirstName());
        updateTeacher.setLastName(teacherDetails.getLastName());
        updateTeacher.setEmailId(teacherDetails.getEmailId());

        // Set new attributes
        updateTeacher.setPassword(teacherDetails.getPassword());
        updateTeacher.setPhoneNumber(teacherDetails.getPhoneNumber());

        teacherRepository.save(updateTeacher);

        return ResponseEntity.ok(updateTeacher);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not exist with id: " + id));

        teacherRepository.delete(teacher);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginTeacher(@RequestBody Teacher teacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacher.getId());

        if (optionalTeacher.isPresent()) {
            Teacher existingTeacher = optionalTeacher.get();

            // Check if the provided password matches the stored password
            if (existingTeacher.getPassword().equals(teacher.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        } else {
            throw new ResourceNotFoundException("Teacher not exist with id:" + teacher.getId());
        }
    }
}
