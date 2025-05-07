package org.sst.bitsspringassignment.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.sst.bitsspringassignment.models.Students;
import org.sst.bitsspringassignment.services.StudentService;
import org.sst.bitsspringassignment.services.CourseService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student_list";
    }

    @GetMapping("/student/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Students());
        model.addAttribute("courses", courseService.getAllCourses());
        return "student_form";
    }

    @PostMapping("/student/save")
    public String saveStudent(@ModelAttribute Students students) {
        studentService.saveStudent(students);
        return "redirect:/";
    }

    @GetMapping("/student/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Students students = studentService.getStudentById(id);
        model.addAttribute("student", students);
        model.addAttribute("courses", courseService.getAllCourses());
        return "student_form";
    }
}