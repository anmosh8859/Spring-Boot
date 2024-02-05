package com.example.spring.service;

import com.example.spring.entity.Student;
import com.example.spring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    public StudentServices(StudentRepository repository) {
        this.repository = repository;
    }

    private StudentRepository repository;

    public Student createStudent(Student student){
        return repository.save(student);
    }

    public Student getStudentById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }
}
