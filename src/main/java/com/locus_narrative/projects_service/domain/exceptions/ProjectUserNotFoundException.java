package com.locus_narrative.projects_service.domain.exceptions;

public class ProjectUserNotFoundException extends Exception {
  public ProjectUserNotFoundException(String message) {
    super(message);
  }
}
