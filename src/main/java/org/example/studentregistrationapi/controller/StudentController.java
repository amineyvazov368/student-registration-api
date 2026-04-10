package org.example.studentregistrationapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentregistrationapi.model.entity.Student;
import org.example.studentregistrationapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid Student student) {
        studentService.registerStudent(student);
        return ResponseEntity.ok("Student registered successfully");
    }


}
