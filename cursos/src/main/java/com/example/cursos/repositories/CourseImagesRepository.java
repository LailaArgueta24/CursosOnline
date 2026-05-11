package com.example.cursos.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.cursos.models.CourseImages;

public interface CourseImagesRepository extends MongoRepository<CourseImages, String> {
    CourseImages findByNcourseId(Integer ncourseId);
}