package com.locus_narrative.projects_service.application.dto;

public interface Response<T> {
    T content();
    int status();
}
