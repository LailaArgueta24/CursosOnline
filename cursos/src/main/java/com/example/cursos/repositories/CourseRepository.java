package com.example.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cursos.models.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {

}
