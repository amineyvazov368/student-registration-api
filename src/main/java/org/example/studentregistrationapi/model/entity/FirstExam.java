package org.example.studentregistrationapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "first_exam")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FirstExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    private Double result;
    private Boolean pass = false;
    private String secondExamQrUrl;


}
