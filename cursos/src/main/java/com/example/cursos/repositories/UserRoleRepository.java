package com.example.cursos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos.models.catalogs.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByCroleCode(String croleCode);
}
