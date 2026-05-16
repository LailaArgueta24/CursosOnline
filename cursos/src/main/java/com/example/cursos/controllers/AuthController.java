package com.example.cursos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursos.dtos.request.LoginRequest;
import com.example.cursos.dtos.request.RegisterRequest;
import com.example.cursos.dtos.response.AuthResponse;
import com.example.cursos.services.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

}

