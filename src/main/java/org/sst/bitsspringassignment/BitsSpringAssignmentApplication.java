package org.sst.bitsspringassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sst.bitsspringassignment.repository.CourseRepository;
import org.sst.bitsspringassignment.repository.StudentRepository;
import org.sst.bitsspringassignment.models.Courses;
import org.sst.bitsspringassignment.models.Students;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BitsSpringAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitsSpringAssignmentApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(StudentRepository studentRepo, CourseRepository courseRepo) {
        return args -> {
            Courses c1 = new Courses(); c1.setTitle("Math");
            Courses c2 = new Courses(); c2.setTitle("Science");
            courseRepo.saveAll(List.of(c1, c2));

            Students s1 = new Students(); s1.setName("Alice"); s1.setCourses(List.of(c1));
            Students s2 = new Students(); s2.setName("Bob"); s2.setCourses(List.of(c1, c2));
            studentRepo.saveAll(List.of(s1, s2));
        };
    }
}
