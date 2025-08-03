package com.locus_narrative.projects_service.presentation.exceptions;

import com.locus_narrative.projects_service.domain.exceptions.ApiException;

public class InvalidUserUuidException extends ApiException {
    public InvalidUserUuidException(String message) {
        super(message, 403);
    }
}
