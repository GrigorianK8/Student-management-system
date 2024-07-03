package com.grigoriank.studentManagementSystem.repository;

import com.grigoriank.studentManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
