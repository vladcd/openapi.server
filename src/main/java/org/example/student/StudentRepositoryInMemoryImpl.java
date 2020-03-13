package org.example.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import org.example.exception.NotFoundException;

@Component
public class StudentRepositoryInMemoryImpl implements StudentRepository {

    private static final List<Student> STUDENTS = new ArrayList<>(Arrays.asList(
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
    ));

    @Override
    public List<Student> findAll() {
        return STUDENTS;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return STUDENTS.stream()
            .filter(student -> student.getId().equals(id))
            .findFirst();
    }

    @Override
    public Student save(Student student) {
        Student result;
        if (student.getId() == null) {
            // get new id
            Integer id = STUDENTS.stream().map(Student::getId).max(Integer::compareTo).orElse(0) + 1;
            result = Student.builder()
                .id(id)
                .name(student.getName())
                .joinDate(LocalDate.now())
                .build();
            STUDENTS.add(result);
        } else {
            result = findById(student.getId()).orElseThrow(NotFoundException::new);
            result.setName(student.getName());
        }
        return result;
    }

    @Override
    public void deleteById(Integer id) {
        Student student = findById(id).orElseThrow(NotFoundException::new);
        STUDENTS.remove(student);
    }
}
