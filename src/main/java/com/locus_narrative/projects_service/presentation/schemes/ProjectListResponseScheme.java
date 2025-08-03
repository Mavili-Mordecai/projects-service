package com.locus_narrative.projects_service.presentation.schemes;

import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;

import java.util.List;

public class ProjectListResponseScheme implements Response<List<ProjectEntity>> {
    @Override
    public List<ProjectEntity> content() {
        return List.of();
    }

    @Override
    public int status() {
        return 0;
    }
}
