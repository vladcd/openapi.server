package org.example.student;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private LocalDate joinDate;
}
