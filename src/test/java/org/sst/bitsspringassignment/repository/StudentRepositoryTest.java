package org.sst.bitsspringassignment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.sst.bitsspringassignment.models.Students;
import org.sst.bitsspringassignment.models.Courses;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testSaveAndFindStudent() {
        // Create a new student
        Students student = new Students();
        student.setName("Test Student");

        // Save the student
        Students savedStudent = studentRepository.save(student);

        // Verify the student was saved
        assertThat(savedStudent.getId()).isNotNull();
        assertThat(savedStudent.getName()).isEqualTo("Test Student");

        // Find the student
        Students foundStudent = studentRepository.findById(savedStudent.getId()).orElse(null);
        assertThat(foundStudent).isNotNull();
        assertThat(foundStudent.getName()).isEqualTo("Test Student");
    }

    @Test
    public void testFindByCourseTitle() {
        // Create a course
        Courses course = new Courses();
        course.setTitle("Test Course");
        courseRepository.save(course);

        // Create students and enroll them in the course
        Students student1 = new Students();
        student1.setName("Student 1");
        student1.setCourses(List.of(course));
        studentRepository.save(student1);

        Students student2 = new Students();
        student2.setName("Student 2");
        student2.setCourses(List.of(course));
        studentRepository.save(student2);

        // Find students by course title
        List<Students> students = studentRepository.findByCourseTitle("Test Course");

        // Verify the results
        assertThat(students).hasSize(2);
        assertThat(students).extracting(Students::getName)
                .containsExactlyInAnyOrder("Student 1", "Student 2");
    }
}