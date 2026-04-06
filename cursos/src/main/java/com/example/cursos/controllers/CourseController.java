package com.example.cursos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursos.models.Course;
import com.example.cursos.services.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Courses", description = "Operaciones para consultar cursos")
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

        @Operation(summary = "Obtener curso por ID", description = "Devuelve un curso específico según su identificador")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class))),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado", content = @Content)
        })
    @GetMapping("/{id}")
        public Course getCourseById(
            @Parameter(description = "ID del curso", example = "1") @PathVariable Long id
        ) {
        return courseService.getCourseById(id);
    }

        @Operation(summary = "Listar todos los cursos", description = "Devuelve la lista completa de cursos")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Course.class))))
        })
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }   
}
