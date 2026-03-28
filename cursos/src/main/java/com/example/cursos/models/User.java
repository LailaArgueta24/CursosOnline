package com.example.cursos.models;

import java.time.LocalDateTime;

import com.example.cursos.models.catalogs.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "TBL_USERS")
@Data                   // getters, setters, toString, equals, hashCode  
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuser_id")
    private Long nuserId;

    @Column(name = "cname", nullable = false, length = 150)
    private String cname;

    @Column(name = "cemail", nullable = false, length = 150, unique = true)
    private String cemail;

    @Column(name = "cpassword_hash", nullable = false, length = 255)
    private String cpasswordHash;

    @ManyToOne(fetch = FetchType.LAZY)// solo se cargará el rol cuando se acceda a él, no al cargar el usuario
    @JoinColumn(name = "nrole_id")
    private UserRole role;

    @Column(name = "bhabilited")
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
    }

    @PreUpdate
    public void preUpdate() {
        this.dupdatedAt = LocalDateTime.now();
    }
}