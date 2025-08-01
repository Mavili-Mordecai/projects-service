package com.locus_narrative.projects_service.application.dto;

import java.util.Optional;

abstract public class Request {
    public Optional<Response<String>> validate() {
        return Optional.empty();
    }
}
