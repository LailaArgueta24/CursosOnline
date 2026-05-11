package com.example.cursos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "TBL_COURSES")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ncourse_id")
    private Integer ncourseId;

    @Column(name = "ctitle", nullable = false, length = 200)
    private String ctitle;

    @Column(name = "cdescription")
    private String cdescription;

    @Column(name = "ncourse_status_id")
    private Integer ncourseStatusId;

    @ManyToOne
    @JoinColumn(name = "ninstructor_id", nullable = false)
    private Instructor instructor;

    @Column(name = "mprice")
    private BigDecimal mprice;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;

    @ManyToMany
    @JoinTable(name = "TBL_COURSE_CATEGORIES",
        joinColumns = @JoinColumn(name = "ncourse_id"),
        inverseJoinColumns = @JoinColumn(name = "ncategory_id"))
    private Set<CourseCategory> categories;
}
