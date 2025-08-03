package com.locus_narrative.projects_service.domain.exceptions;

public class ProjectUserNotFoundException extends ApiException {
    public ProjectUserNotFoundException(String message) {
        super(message, 404);
    }

    public ProjectUserNotFoundException() {
        super("Project or user in the project not found.", 404);
    }
}
