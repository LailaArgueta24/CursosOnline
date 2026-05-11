package com.example.cursos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNuserId(Integer nuserId);
    Optional<User> findByCuser(String cuser);
}
