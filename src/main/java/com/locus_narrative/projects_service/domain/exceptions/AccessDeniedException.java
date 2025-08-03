package com.locus_narrative.projects_service.domain.exceptions;

public class AccessDeniedException extends ApiException {

    public AccessDeniedException() {
        super("Access denied", 403);
    }

    public AccessDeniedException(String message) {
        super(message, 403);
    }
}
