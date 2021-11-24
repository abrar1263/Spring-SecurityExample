package com.perfectsqaure.SpringSecurity.student.service;

import com.perfectsqaure.SpringSecurity.student.model.Student;
import com.perfectsqaure.SpringSecurity.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Service
@Component
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByStudentID(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student insertStudent(Student s) {
        if(s!=null){
            studentRepository.save(s);
        }
        return s;
    }
}
