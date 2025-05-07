package org.sst.bitsspringassignment.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.sst.bitsspringassignment.models.Students;
import java.util.*;

public interface StudentRepository extends JpaRepository<Students, Long> {
    @Query("SELECT s FROM Students s JOIN s.courses c WHERE c.title = :title")
    List<Students> findByCourseTitle(@Param("title") String title);
}
