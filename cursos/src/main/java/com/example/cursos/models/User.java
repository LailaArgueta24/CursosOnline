package com.example.cursos.models;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "TBL_USERS")
@Data                   // getters, setters, toString, equals, hashCode  
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuser_id")
    private Integer nuserId;

    @Column(name = "cuser", nullable = false, length = 150)
    private String cuser;

    @Column(name = "cname", nullable = false, length = 150)
    private String cname;

    @Column(name = "cemail", nullable = false, length = 150, unique = true)
    private String cemail;

    @Column(name = "cpassword_hash", nullable = false, length = 255)
    private String cpasswordHash;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nrole_id")
    private UserRole role;

    @Column(name = "bhabilited")
    @Default
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
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null || role.getCroleName() == null) {
            return Collections.emptyList();
        }
        return List.of(new SimpleGrantedAuthority(role.getCroleName()));
    }
    @Override
    public String getPassword() {
        return cpasswordHash;
    }
    @Override
    public String getUsername() {
        return cuser;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return bhabilited;
    }
}