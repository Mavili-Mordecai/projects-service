package com.locus_narrative.projects_service.domain.exceptions;

public class AccessDeniedException extends Exception {
    public AccessDeniedException(String message) {
        super(message);
    }
}
