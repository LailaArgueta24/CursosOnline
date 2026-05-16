package com.example.cursos.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.cursos.exception.DuplicateResourceException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(IllegalArgumentException exception) {
        // Si el mensaje es sobre credenciales, devolver UNAUTHORIZED
        if (exception.getMessage().contains("credentials") || exception.getMessage().contains("password")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", exception.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(Map.of("error", exception.getMessage()));
    }

    @ExceptionHandler({ IllegalStateException.class, UsernameNotFoundException.class })
    public ResponseEntity<Map<String, String>> handleNotFound(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of("error", exception.getMessage()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorized(BadCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(Map.of("error", "Invalid username or password"));
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<Map<String, String>> handleDuplicate(DuplicateResourceException exception) {
        String field = exception.getField() != null ? exception.getField() : "general";
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(Map.of("field", field, "message", exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("error", "Internal server error: " + exception.getMessage()));
    }
}