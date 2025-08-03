package com.locus_narrative.projects_service.domain.exceptions;

public class ProjectNotFoundException extends ApiException {
    public ProjectNotFoundException(String message) {
        super(message, 404);
    }

    public ProjectNotFoundException() {
        super("Project not found", 404);
    }
}
