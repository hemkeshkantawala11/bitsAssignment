package org.sst.bitsspringassignment.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sst.bitsspringassignment.models.Students;
import org.sst.bitsspringassignment.repository.StudentRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        Students student1 = new Students();
        student1.setId(1L);
        student1.setName("Student 1");

        Students student2 = new Students();
        student2.setId(2L);
        student2.setName("Student 2");

        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        // Act
        List<Students> students = studentService.getAllStudents();

        // Assert
        assertThat(students).hasSize(2);
        assertThat(students).extracting(Students::getName)
                .containsExactlyInAnyOrder("Student 1", "Student 2");
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testSaveStudent() {
        // Arrange
        Students student = new Students();
        student.setName("New Student");

        Students savedStudent = new Students();
        savedStudent.setId(1L);
        savedStudent.setName("New Student");

        when(studentRepository.save(any(Students.class))).thenReturn(savedStudent);

        // Act
        Students result = studentService.saveStudent(student);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("New Student");
        verify(studentRepository, times(1)).save(any(Students.class));
    }

    @Test
    void testGetStudentById() {
        // Arrange
        Students student = new Students();
        student.setId(1L);
        student.setName("Test Student");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        // Act
        Students result = studentService.getStudentById(1L);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Test Student");
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testGetStudentByIdNotFound() {
        // Arrange
        when(studentRepository.findById(999L)).thenReturn(Optional.empty());

        // Act
        Students result = studentService.getStudentById(999L);

        // Assert
        assertThat(result).isNull();
        verify(studentRepository, times(1)).findById(999L);
    }
}