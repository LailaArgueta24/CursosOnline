package com.example.cursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursos.models.User;
public interface UserRepository extends JpaRepository<User, Long> {
}
