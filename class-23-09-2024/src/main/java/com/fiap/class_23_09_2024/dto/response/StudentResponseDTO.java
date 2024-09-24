package com.fiap.class_23_09_2024.dto.response;

import com.fiap.class_23_09_2024.model.Student;

import java.time.LocalDate;

public record StudentResponseDTO(
        Integer id,
        String schoolRegistration,
        String name,
        LocalDate birthDate,
        String course,
        String email,
        String document
) {
    public StudentResponseDTO(Student student){
        this(student.getId(),
            student.getSchoolRegistration(),
            student.getName(),
            student.getBirthDate(),
            student.getCourse(),
            student.getEmail(),
            student.getDocument());
    }
}
