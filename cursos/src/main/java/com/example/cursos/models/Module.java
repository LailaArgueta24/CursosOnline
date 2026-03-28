package com.example.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_MODULES")  
@Data
public class Module {
    @Id
    @Column(name = "nmodule_id", nullable = false)
    private Long nmoduleId;

    @Column(name = "ctitle", nullable = false, length = 150)
    private String ctitle;

    @ManyToOne
    @JoinColumn(name = "ncourse_id", nullable = false)
    private Course ncourseId;

    @Column(name = "nsort_order")
    private Integer nsortOrder;
}
