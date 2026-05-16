package com.example.cursos.exception;

public class DuplicateResourceException extends RuntimeException {
    private final String field;

    public DuplicateResourceException(String message) {
        super(message);
        this.field = null;
    }

    public DuplicateResourceException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
