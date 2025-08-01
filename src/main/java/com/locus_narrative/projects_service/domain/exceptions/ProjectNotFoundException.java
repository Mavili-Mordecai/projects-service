package com.locus_narrative.projects_service.domain.exceptions;

public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException(String message) {
        super(message);
    }
}
