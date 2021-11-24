package com.perfectsqaure.SpringSecurity.student.repo;

import com.perfectsqaure.SpringSecurity.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
