package com.locus_narrative.projects_service.domain.exceptions;

public class ProjectUserAlreadyExistsException extends ApiException {
    public ProjectUserAlreadyExistsException(String message) {
        super(message, 409);
    }

    public ProjectUserAlreadyExistsException() {
        super("The user has already been added to the project.", 409);
    }
}
