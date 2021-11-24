package com.perfectsqaure.SpringSecurity.student.service;

import com.perfectsqaure.SpringSecurity.student.model.Student;

import java.util.List;

public interface StudentService {


    public List<Student> getAllStudent();

    public Student findByStudentID(long id);

    public Student insertStudent(Student s);
}
