package com.example.cursos.models;
import com.example.cursos.models.catalogs.CartStatus;

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
@Table(name = "TBL_PAYMENTS")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ncart_id", nullable = false)
    private Long ncartId;

    @ManyToOne
    @JoinColumn(name = "nuser_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ncart_status_id", nullable = false)
    private CartStatus cartStatus;
}
