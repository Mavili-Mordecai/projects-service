package com.locus_narrative.projects_service.application.dto;

public interface IResponse<T> {
    T getContent();
    int getStatus();
}
