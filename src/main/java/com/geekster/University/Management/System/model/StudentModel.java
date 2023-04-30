package com.geekster.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student_tbl")
@Entity
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]*")
    private String firstName;
    private  String lastName;
    @NotNull
    @Min(18)
    @Max(25)
    private  int age;
    @Enumerated(EnumType.STRING)
    private  Department department;
}

