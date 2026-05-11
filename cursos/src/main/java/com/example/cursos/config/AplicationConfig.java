package com.example.cursos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.cursos.models.catalogs.UserRole;
import com.example.cursos.repositories.UserRoleRepository;
import com.example.cursos.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AplicationConfig {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByCuser(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public CommandLineRunner seedDefaultRoles() {
        return args -> {
            createRoleIfMissing(1, "ADMIN", "ADMIN");
            createRoleIfMissing(2, "INSTRUCTOR", "INSTRUCTOR");
            createRoleIfMissing(3, "STUDENT", "STUDENT");
        };
    }

    private void createRoleIfMissing(Integer id, String code, String name) {
        userRoleRepository.findById(id).orElseGet(() -> {
            UserRole userRole = new UserRole();
            userRole.setNroleId(id);
            userRole.setCroleCode(code);
            userRole.setCroleName(name);
            userRole.setBhabilited(true);
            return userRoleRepository.save(userRole);
        });
    }
}
