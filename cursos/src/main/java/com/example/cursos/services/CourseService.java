package com.example.cursos.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cursos.models.Course;
import com.example.cursos.repositories.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}