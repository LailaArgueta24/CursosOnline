package com.example.cursos.services;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.cursos.dtos.CourseDetailDto;
import com.example.cursos.dtos.CourseDto;
import com.example.cursos.dtos.InstructorDetailDto;
import com.example.cursos.models.Course;
import com.example.cursos.models.CourseImages;
import com.example.cursos.models.Instructor;
import com.example.cursos.repositories.CourseImagesRepository;
import com.example.cursos.repositories.CourseRepository;
import com.example.cursos.repositories.InstructorRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseImagesRepository courseImagesRepository;

    public CourseService(CourseRepository courseRepository,
                         CourseImagesRepository courseImagesRepository){
        this.courseRepository = courseRepository;
        this.courseImagesRepository = courseImagesRepository;
    };

    public CourseDetailDto getCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return null;
        }
        
        Instructor instructor = course.getInstructor();
        InstructorDetailDto instructorDTO = new InstructorDetailDto();
        if (instructor != null) {
            instructorDTO.setNinstructorId(instructor.getNinstructorId());
            instructorDTO.setCname(instructor.getUser().getCname());
        }
        
        CourseImages imgs = courseImagesRepository.findByNcourseId(course.getNcourseId());

        return new CourseDetailDto(course.getNcourseId(),
                                   course.getCtitle(),
                                   course.getCdescription(),
                                   instructorDTO,
                                   course.getMprice(),
                                   imgs != null ? imgs.getImages() : List.of());
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