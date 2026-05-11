package com.example.cursos.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id; 
import lombok.Data;

@Data
@Document(collection = "IMAGENES")
public class CourseImages {

    @Id
    private String id;

    @Field("ncourseId")
    private Integer ncourseId;

    private List<String> images;

}
