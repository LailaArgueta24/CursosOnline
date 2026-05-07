package com.example.cursos.models;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CAT_COURSE_CATEGORIES")
@Data
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ncategory_id", nullable = false)
    private Integer ncategoryId;

    @Column(name = "ccategory_name", nullable = false, length = 100)
    private String ccategoryName;

    @Column(name = "cdescription", length = 255)
    private String cdescription;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
