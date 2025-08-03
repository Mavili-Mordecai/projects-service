package com.locus_narrative.projects_service.presentation.controllers;

import com.locus_narrative.projects_service.presentation.exceptions.InvalidUserUuidException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

abstract public class BaseController {
    public UUID getUserUuid() throws InvalidUserUuidException {
        try {
            return UUID.fromString(
                    SecurityContextHolder.getContext().getAuthentication().getName()
            );
        } catch (IllegalArgumentException ex) {
            throw new InvalidUserUuidException("The `sub` field in the JWT token must be a valid UUID.");
        }
    }
}
