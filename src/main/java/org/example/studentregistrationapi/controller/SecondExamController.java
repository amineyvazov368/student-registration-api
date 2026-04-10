package org.example.studentregistrationapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.studentregistrationapi.model.dto.RegisterRequest;
import org.example.studentregistrationapi.model.entity.SecondExam;
import org.example.studentregistrationapi.service.SecondExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondExam")
@RequiredArgsConstructor
public class SecondExamController {


    private final SecondExamService secondExamService;

    @PostMapping("/register")
    public ResponseEntity<?> registerSecondExam(@RequestBody @Valid RegisterRequest registerRequest) {
        try {
            String qrPath = secondExamService.registerStudent(registerRequest);
            return ResponseEntity.ok(qrPath);

        }catch (Exception e) {
            switch (e.getMessage()) {
                case "Invalid credentials":
                    return ResponseEntity.status(401).body(e.getMessage());

                case "First exam not found":
                    return ResponseEntity.status(404).body(e.getMessage());

                case "Exam not passed":
                    return ResponseEntity.status(403).body(e.getMessage());

                case "QR already exists":
                    return ResponseEntity.status(409).body(e.getMessage());

                default:
                    return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

}
