package com.locus_narrative.projects_service.presentation.schemes;

import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;

public class ProjectResponseScheme implements Response<ProjectEntity> {
    @Override
    public ProjectEntity content() {
        return null;
    }

    @Override
    public int status() {
        return 0;
    }
}
