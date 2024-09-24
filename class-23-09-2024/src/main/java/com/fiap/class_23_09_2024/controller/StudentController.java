package com.fiap.class_23_09_2024.controller;

import com.fiap.class_23_09_2024.mapper.StudentMapper;
import com.fiap.class_23_09_2024.dto.request.StudentCreationRequestDTO;
import com.fiap.class_23_09_2024.dto.response.StudentResponseDTO;
import com.fiap.class_23_09_2024.model.Student;
import com.fiap.class_23_09_2024.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentServiceImpl) {
        this.studentService = studentServiceImpl;
    }

    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentCreationRequestDTO request){
        Student studentRequest = StudentMapper.toStudent(request);
        Student studentCreated = studentService.createStudent(studentRequest);
        StudentResponseDTO response = StudentMapper.toResponse(studentCreated);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
