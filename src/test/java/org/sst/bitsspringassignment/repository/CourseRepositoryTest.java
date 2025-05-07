package org.sst.bitsspringassignment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.sst.bitsspringassignment.models.Courses;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testSaveAndFindCourse() {
        // Create a new course
        Courses course = new Courses();
        course.setTitle("Test Course");

        // Save the course
        Courses savedCourse = courseRepository.save(course);

        // Verify the course was saved
        assertThat(savedCourse.getId()).isNotNull();
        assertThat(savedCourse.getTitle()).isEqualTo("Test Course");

        // Find the course
        Courses foundCourse = courseRepository.findById(savedCourse.getId()).orElse(null);
        assertThat(foundCourse).isNotNull();
        assertThat(foundCourse.getTitle()).isEqualTo("Test Course");
    }

    @Test
    public void testFindAllCourses() {
        // Create multiple courses
        Courses course1 = new Courses();
        course1.setTitle("Course 1");
        Courses course2 = new Courses();
        course2.setTitle("Course 2");

        courseRepository.save(course1);
        courseRepository.save(course2);

        // Find all courses
        List<Courses> courses = courseRepository.findAll();

        // Verify the results
        assertThat(courses).hasSize(2);
        assertThat(courses).extracting(Courses::getTitle)
                .containsExactlyInAnyOrder("Course 1", "Course 2");
    }
} 