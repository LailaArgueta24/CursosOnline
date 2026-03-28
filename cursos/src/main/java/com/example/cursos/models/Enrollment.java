package com.example.cursos.models;

import com.example.cursos.models.catalogs.EnrollmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_ENROLLMENTS")
@Data
public class Enrollment {
    @Id
    @Column(name = "nenrollment_id", nullable = false)
    private Long nenrollmentId;

    @ManyToOne
    @JoinColumn(name = "nuser_id", nullable = false)
    private User nuserId;

    @ManyToOne
    @JoinColumn(name = "ncourse_id", nullable = false)
    private Course ncourseId;

    @ManyToOne
    @JoinColumn(name = "nenrollment_status_id", nullable = false)
    private EnrollmentStatus nenrollmentStatus;

    @Column(name = "bhabilited", nullable = false)
    private Boolean bhabilited;

    @Column(name = "dcreated_at", nullable = false)
    private String dcreatedAt;

    @Column(name = "dupdated_at", nullable = false)
    private String dupdatedAt;

    @Column(name= "deleted_at")
    private String deletedAt;
}
