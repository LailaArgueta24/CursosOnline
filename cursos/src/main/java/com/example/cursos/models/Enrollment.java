package com.example.cursos.models;

import com.example.cursos.models.catalogs.EnrollmentStatus;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_ENROLLMENTS")
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nenrollment_id", nullable = false)
    private Integer nenrollmentId;

    @ManyToOne
    @JoinColumn(name = "nstudent_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "ncourse_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "nenrollment_status_id", nullable = false)
    private EnrollmentStatus nenrollmentStatus;

    @Column(name = "denrolled_at")
    private LocalDateTime denrolledAt;

    @Column(name = "bhabilited", nullable = false)
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;

    @PrePersist
    public void prePersist() {
        this.dcreatedAt = LocalDateTime.now();
        if (this.denrolledAt == null) this.denrolledAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dupdatedAt = LocalDateTime.now();
    }
}
