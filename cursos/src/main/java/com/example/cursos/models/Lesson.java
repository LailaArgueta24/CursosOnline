package com.example.cursos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_LESSONS")
@Data
public class Lesson {
    @Id
    @Column(name = "nlesson_id", nullable = false)
    private Long nlessonId;

    @ManyToOne
    @JoinColumn(name = "nmodule_id", nullable = false)
    private Module nmoduleId;

    @Column(name = "ctitle", nullable = false, length = 150)
    private String ctitle;

    @Column(name = "ccontent_url", length = 500)
    private String ccontentUrl;

    @Column(name = "nsort_order") 
    private Integer nsortOrder;

}
