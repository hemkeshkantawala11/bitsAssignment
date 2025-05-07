package org.sst.bitsspringassignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sst.bitsspringassignment.models.Courses;
import org.sst.bitsspringassignment.repository.CourseRepository;
import java.util.*;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepo;

    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }

    public Courses saveCourse(Courses courses) {
        return courseRepo.save(courses);
    }

    public Courses getCourseById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }
}