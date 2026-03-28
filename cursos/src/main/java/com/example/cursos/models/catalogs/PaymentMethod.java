package com.example.cursos.models.catalogs;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "CAT_PAYMENT_METHOD")
@Data
public class PaymentMethod {
    @Id
    @Column(name = "npayment_method_id", nullable = false)
    private Long npaymentMethodId;
    
    @Column(name = "cmethod_code", nullable = false, length = 50, unique = true)
    private String cmethodCode;

    @Column(name = "cmethod_name", nullable = false, length = 100, unique = true)
    private String cmethodName;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
