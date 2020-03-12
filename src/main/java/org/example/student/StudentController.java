package org.example.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.example.rest.api.StudentApi;
import org.example.rest.model.StudentDTO;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@RestController
public class StudentController implements StudentApi {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentWSMapper studentMapper;

    @Override
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentMapper.toStudentDTOList(studentService.getStudents()));
    }
}
