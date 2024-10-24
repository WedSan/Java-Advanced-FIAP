package com.fiap.class_23_09_2024.service;

import com.fiap.class_23_09_2024.model.Student;
import com.fiap.class_23_09_2024.repository.StudentRepository;

public class StudentDocumentValidator implements StudentCreationValidator{

    private StudentRepository repository;

    @Override
    public void validate(Student student) {
        if(repository.existsStudentByDocument(student.getDocument())){
            throw new RuntimeException("Student with document " + student.getDocument() + " already exists");
        }
    }
}
