package com.example.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_CART_ITEMS")
@Data
public class CartItems {
    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "ncart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "ncourse_id", nullable = false)
    private Course course;

    @Column(name = "mprice", nullable = false)
    private Double price;

}
