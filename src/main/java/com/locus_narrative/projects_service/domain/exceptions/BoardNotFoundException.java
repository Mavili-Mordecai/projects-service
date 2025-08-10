package com.locus_narrative.projects_service.domain.exceptions;

public class BoardNotFoundException extends ApiException {
    public BoardNotFoundException(String message) {
        super(message, 404);
    }

    public BoardNotFoundException() {
        super("Board not found", 404);
    }
}
