package org.example.studentregistrationapi.repository;

import org.example.studentregistrationapi.model.entity.FirstExam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirstExamRepository extends JpaRepository<FirstExam, Long> {
    Optional<FirstExam> findByStudentId(Long studentId);
}
