package com.example.cursos.models;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_CART_ITEMS")
@Data
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nreview_id", nullable = false)
    private Long nreviewId;

    @ManyToOne
    @JoinColumn(name = "ncourse_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "nuser_id", nullable = false)
    private User user;

    @Column(name = "nrating", nullable = false)
    private Integer nrating;
    
    @Column(name = "ccomment", length = 500)
    private String ccomment;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
