package com.example.cursos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstructorDetailDto {
    private Integer ninstructorId;
    private String cname;
    private String cbiography;
    private String cemail;
}
