package org.sst.bitsspringassignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.sst.bitsspringassignment.models.Courses;
import org.sst.bitsspringassignment.services.CourseService;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course_list";
    }

    @GetMapping("/courses/add")
    public String addForm(Model model) {
        model.addAttribute("course", new Courses());
        return "course_form";
    }

    @PostMapping("/courses/save")
    public String saveCourse(@ModelAttribute Courses course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Courses course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "course_form";
    }
}