package com.example.cursos.dtos;

import java.math.BigDecimal;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CourseDetailDto {
    private Integer ncourseId;
    private String ctitle;
    private String cdescription;
    private InstructorDetailDto instructorDetailDto;
    private BigDecimal mprice;
    private List<String> images;
}
