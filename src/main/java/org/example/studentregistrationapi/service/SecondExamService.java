package org.example.studentregistrationapi.service;

import lombok.AllArgsConstructor;
import org.example.studentregistrationapi.model.dto.RegisterRequest;
import org.example.studentregistrationapi.model.entity.FirstExam;
import org.example.studentregistrationapi.model.entity.SecondExam;
import org.example.studentregistrationapi.model.entity.Student;
import org.example.studentregistrationapi.repository.FirstExamRepository;
import org.example.studentregistrationapi.repository.SecondExamRepository;
import org.example.studentregistrationapi.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecondExamService {

    private final StudentRepository studentRepository;
    private final FirstExamRepository firstExamRepository;
    private final SecondExamRepository secondExamRepository;
    private final PasswordEncoder passwordEncoder;
    private  final QrService qrService;
    private final EmailService emailService;

    public String registerStudent(RegisterRequest registerRequest) {

        Student student = studentRepository.findStudentByEmail(registerRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (!passwordEncoder.matches(registerRequest.getPassword(), student.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

       FirstExam firstExam=  firstExamRepository.findByStudentId(student.getId())
                .orElseThrow(() -> new RuntimeException("First exam not found"));

        if (!firstExam.getPass()){
            throw new RuntimeException("Exam not passed");
        }

        if (firstExam.getSecondExamQrUrl() != null){
            throw new RuntimeException("QR already exists");
        }

        String qrContent= "SECOND_EXAM" + student.getId();
        String qrPath = qrService.generateQrCode(qrContent);

        firstExam.setSecondExamQrUrl(qrPath);
        firstExamRepository.save(firstExam);

        SecondExam secondExam = new SecondExam();
        secondExam.setStudent(student);
        secondExamRepository.save(secondExam);

        emailService.sendEmail(student.getEmail(),qrPath);

        return qrPath;
    }
}
