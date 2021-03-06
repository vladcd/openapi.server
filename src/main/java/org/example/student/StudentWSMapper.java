package org.example.student;

import java.util.List;

import org.example.rest.model.StudentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudentWSMapper {

    List<StudentDTO> toStudentDTOList(List<Student> students);

    StudentDTO toStudentDTO(Student student);

    Student toStudent(StudentDTO studentDTO);
}
