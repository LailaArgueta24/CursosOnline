package com.example.cursos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_COURSES")
@Data
public class Course {
    @Id
    @Column(name = "ncourse_id")
    private Long ncourseId;

    @Column(name = "ctitle", nullable = false, length = 200)
    private String ctitle;

    @Column(name = "cdescription")
    private String cdescription;

    // @ManyToOne
    // @JoinColumn(name = "ninstructor_id")
    // private Instructor instructor;

    @Column(name = "ncourse_status_id")
    private Long ncourseStatusId;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
