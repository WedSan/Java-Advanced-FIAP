package com.fiap.class_23_09_2024.service;

import com.fiap.class_23_09_2024.repository.StudentRepository;

import java.util.Optional;

public class SchoolRegistrationGeneratorImpl implements SchoolRegistrationGenerator{

    private StudentRepository studentRepository;

    public SchoolRegistrationGeneratorImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String generate() {
        Optional<String> schoolRegistrationOptional = studentRepository.findLastSchoolRegistration();
        if(schoolRegistrationOptional.isEmpty()){
            return "RM1"; 
        }
        String lastSchoolRegistration = schoolRegistrationOptional.get();
        int lastSchoolRegistrationNumber = Integer.parseInt(lastSchoolRegistration.substring(0, 2));
        return "RM" + (lastSchoolRegistrationNumber + 1);
    }
}




