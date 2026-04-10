package org.example.studentregistrationapi.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.studentregistrationapi.model.entity.Student;
import org.example.studentregistrationapi.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);

    }
}
