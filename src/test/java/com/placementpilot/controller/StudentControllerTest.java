package com.placementpilot.controller;

import com.placementpilot.model.Student;
import com.placementpilot.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentControllerTest {

    private final StudentRepository repository = Mockito.mock(StudentRepository.class);
    private final StudentController controller = new StudentController(repository);

    @Test
    void addStudentSavesAndReturnsStudent() {
        Student student = new Student();
        student.setName("Test Student");
        student.setCgpa(8.5);
        Mockito.when(repository.save(student)).thenReturn(student);

        Student result = controller.addStudent(student);

        assertEquals("Test Student", result.getName());
        assertEquals(8.5, result.getCgpa());
        Mockito.verify(repository).save(student);
    }

    @Test
    void getAllStudentsReturnsAllStudents() {
        Student student = new Student();
        student.setName("Asha");
        Mockito.when(repository.findAll()).thenReturn(List.of(student));

        List<Student> result = controller.getAllStudents();

        assertEquals(1, result.size());
        assertEquals("Asha", result.get(0).getName());
    }
}
