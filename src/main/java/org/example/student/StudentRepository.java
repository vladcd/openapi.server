package org.example.student;

import java.util.List;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
public interface StudentRepository {

    List<Student> findAll();
}
