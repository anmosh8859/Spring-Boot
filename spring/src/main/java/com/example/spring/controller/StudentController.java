package com.example.spring.controller;

import com.example.spring.entity.Student;
import com.example.spring.service.StudentServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    public StudentController(StudentServices service) {
        this.service = service;
    }

    private StudentServices service;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @GetMapping
    public List<Student> getStudentById(){
        return service.getStudents();
    }
}
