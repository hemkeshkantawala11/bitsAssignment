package org.sst.bitsspringassignment.services;
import org.springframework.stereotype.Service;
import org.sst.bitsspringassignment.models.Students;
import org.sst.bitsspringassignment.repository.StudentRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }

    public Students saveStudent(Students students) {
        return studentRepo.save(students);
    }

    public Students getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }
}


