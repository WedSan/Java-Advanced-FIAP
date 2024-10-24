package com.fiap.class_23_09_2024.service;

import com.fiap.class_23_09_2024.exception.StudentNotFoundException;
import com.fiap.class_23_09_2024.model.Student;
import com.fiap.class_23_09_2024.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private List<StudentCreationValidator> studentCreationValidators;

    private StudentRepository studentRepository;

    private SchoolRegistrationGenerator registrationGenerator;

    private StudentEmailValidator studentEmailValidator;

    public StudentServiceImpl(List<StudentCreationValidator> studentCreationValidators, StudentRepository studentRepository, SchoolRegistrationGenerator registrationGenerator) {
        this.studentCreationValidators = studentCreationValidators;
        this.studentRepository = studentRepository;
        this.registrationGenerator = registrationGenerator;
    }

    @Override
    public Student createStudent(Student studentToBeCreated) {
        studentCreationValidators.forEach(validator -> validator.validate(studentToBeCreated));
        studentToBeCreated.setSchoolRegistration(registrationGenerator.generate());
        return studentRepository.save(studentToBeCreated);
    }

    @Override
    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException());
    }

    @Override
    public void updateStudent(int id, String email) {
        Student student = findStudentById(id);
        studentEmailValidator.validate(student);
        student.setEmail(email);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id){
        Student student = findStudentById(id);
        studentRepository.delete(student);
    }
}
