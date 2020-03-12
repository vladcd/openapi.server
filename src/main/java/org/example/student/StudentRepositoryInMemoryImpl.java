package org.example.student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Component
public class StudentRepositoryInMemoryImpl implements StudentRepository {

    private static final List<Student> STUDENTS = Arrays.asList(
        Student.builder()
            .id(1)
            .name("Vlad Carcu")
            .joinDate(LocalDate.now())
            .build(),
        Student.builder()
            .id(2)
            .name("John Doe")
            .joinDate(LocalDate.now())
            .build()
    );

    @Override
    public List<Student> findAll() {
        return STUDENTS;
    }
}
