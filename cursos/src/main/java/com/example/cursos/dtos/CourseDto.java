package com.example.cursos.dtos;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDto {
    private String ctitle;
    private String cdescription;
    private List<String> images;

    /* Con la etiqueta de arriba se evita crear el constructor.
    public CourseDto(String ctitle, String cdescription) {
        this.ctitle = ctitle;
        this.cdescription = cdescription;
    }
         */
}
