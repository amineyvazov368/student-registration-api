package org.example.studentregistrationapi.repository;

import org.example.studentregistrationapi.model.entity.SecondExam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecondExamRepository extends JpaRepository<SecondExam, Long> {
    Optional<SecondExam> findByStudentId(Long studentId);


}
