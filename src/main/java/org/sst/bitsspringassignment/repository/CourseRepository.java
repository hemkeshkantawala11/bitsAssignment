package org.sst.bitsspringassignment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.sst.bitsspringassignment.models.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {}

