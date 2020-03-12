package org.example.student;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
public interface StudentRepository {

    List<Student> findAll();

    Optional<Student> findById(Integer id);

    Student save(Student student);

    void deleteById(Integer id);
}
