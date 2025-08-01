package com.locus_narrative.projects_service.application.dto;

public record GenericResponse<T>(T content, int status) implements Response<T> {
}
