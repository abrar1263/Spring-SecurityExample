package com.perfectsqaure.SpringSecurity.student.controller;

import com.perfectsqaure.SpringSecurity.student.model.Student;
import com.perfectsqaure.SpringSecurity.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
        return student;
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") long id){
        return studentService.findByStudentID(id);
    }
}
