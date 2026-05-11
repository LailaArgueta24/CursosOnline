package com.example.cursos.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.cursos.dtos.CourseDto;
import com.example.cursos.models.Course;
import com.example.cursos.models.CourseImages;
import com.example.cursos.repositories.CourseImagesRepository;
import com.example.cursos.repositories.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseImagesRepository courseImagesRepository;

    public CourseService(CourseRepository courseRepository,
                         CourseImagesRepository courseImagesRepository){
        this.courseRepository = courseRepository;
        this.courseImagesRepository = courseImagesRepository;
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }
    
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
            
                .map(course ->{
                    
                    CourseImages imgs = 
                    courseImagesRepository.findByNcourseId(course.getNcourseId());
                    
                    return new CourseDto(course.getCtitle(),
                        course.getCdescription(),
                        imgs != null ? imgs.getImages() : List.of());
                })
                .toList();
    }
}