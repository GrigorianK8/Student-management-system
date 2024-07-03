package com.grigoriank.studentManagementSystem.service;

import com.grigoriank.studentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);
}
