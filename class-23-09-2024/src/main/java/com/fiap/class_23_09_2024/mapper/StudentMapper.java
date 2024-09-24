package com.fiap.class_23_09_2024.mapper;

import com.fiap.class_23_09_2024.dto.request.StudentCreationRequestDTO;
import com.fiap.class_23_09_2024.dto.response.StudentResponseDTO;
import com.fiap.class_23_09_2024.model.Student;

public class StudentMapper {

    public static Student toStudent(StudentCreationRequestDTO dto){
        Student student =  new Student();
        student.setName(dto.name());
        student.setDocument(dto.document());
        student.setEmail(dto.email());
        student.setCourse(dto.course());
        student.setBirthDate(dto.birthday());
        return student;
    }

    public static StudentResponseDTO toResponse(Student student){
        return new StudentResponseDTO(student);
    }
}
