package com.example.cursos.models;
import java.time.LocalDateTime;

import com.example.cursos.models.catalogs.PaymentMethod;
import com.example.cursos.models.catalogs.PaymentStatus;

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
public class Payment {
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "npayment_id", nullable = false)
    private Long npaymentId;

    @Column(name = "mamount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "nenrollment_id", nullable = false)
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "npayment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne 
    @JoinColumn(name = "npayment_status_id", nullable = false)
    private PaymentStatus paymentStatus;

    @Column(name = "dpayment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
