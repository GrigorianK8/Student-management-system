package com.grigoriank.studentManagementSystem.controller;

import com.grigoriank.studentManagementSystem.entity.Student;
import com.grigoriank.studentManagementSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String getAll(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/new")
    public String create(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "createStudent";
    }

    @PostMapping("/students")
    public String save(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "editStudent";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
