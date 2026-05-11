package com.example.cursos.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cursos.dtos.request.LoginRequest;
import com.example.cursos.dtos.request.RegisterRequest;
import com.example.cursos.dtos.response.AuthResponse;
import com.example.cursos.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.cursos.models.catalogs.UserRole;
import com.example.cursos.repositories.UserRoleRepository;
import com.example.cursos.repositories.UserRepository;
import com.example.cursos.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getCuser(),
                request.getCpasswordHash()
            )
        );
        UserDetails userDetails = userRepository.findByCuser(request.getCuser())
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
            .token(token)
            .build();
    }
    public AuthResponse register(RegisterRequest request) {
        if (request.getNroleId() == null) {
            throw new IllegalArgumentException("nroleId is required");
        }

        UserRole selectedRole = userRoleRepository.findById(request.getNroleId())
            .orElseThrow(() -> new IllegalStateException("Role not found: " + request.getNroleId()));

        User user = User.builder()
            .cuser(request.getCuser())
            .cpasswordHash(passwordEncoder.encode(request.getCpasswordHash()))
            .cemail(request.getCemail())
            .cname(request.getCname())
            .role(selectedRole)
            .build();
        userRepository.save(user);
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
