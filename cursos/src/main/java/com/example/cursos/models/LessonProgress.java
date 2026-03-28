package com.example.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_LESSON_PROGRESS")
@Data
public class LessonProgress {
    @Id
    @Column(name = "nprogress_id")
    private Long nprogressId;

    @ManyToOne 
    @JoinColumn(name="nenrollment_id")
    private Enrollment enrollment;

    @ManyToOne 
    @JoinColumn(name="nlesson_id")
    private Lesson lesson;

    @Column(name = "bcompleted", nullable = false)
    private Boolean bcompleted;
}
