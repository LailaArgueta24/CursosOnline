package com.example.cursos.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_WISHLIST")
@Data
public class Wishlist {
    @EmbeddedId
    private WishlistKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "nstudent_id", nullable = false)
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "ncourse_id", nullable = false)
    private Course course;

    @Column(name = "dcreated_at")
    private LocalDateTime dcreatedAt;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WishlistKey implements Serializable {
        @Column(name = "nstudent_id")
        private Integer studentId;

        @Column(name = "ncourse_id")
        private Integer courseId;
    }
}
