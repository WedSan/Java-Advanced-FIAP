package com.fiap.class_23_09_2024.service;

import com.fiap.class_23_09_2024.exception.EmailAlreadyExistsException;
import com.fiap.class_23_09_2024.model.Student;
import com.fiap.class_23_09_2024.repository.StudentRepository;

public class StudentEmailValidator implements StudentCreationValidator{

    private StudentRepository repository;

    public StudentEmailValidator(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Student student) {
        if(repository.existsStudentByEmail(student.getEmail())){
            throw new EmailAlreadyExistsException();
        }
    }
}
