package com.example.cursos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_STUDENTS")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nstudent_id", nullable = false)
    private Integer nstudentId;

    @OneToOne
    @JoinColumn(name = "nuser_id", nullable = false)
    private User user;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
