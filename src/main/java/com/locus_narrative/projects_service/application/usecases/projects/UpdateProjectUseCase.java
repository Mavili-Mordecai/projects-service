package com.locus_narrative.projects_service.application.usecases.projects;

import com.locus_narrative.projects_service.application.dto.requests.projects.UpdateProjectRequest;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;

import java.util.UUID;

public class UpdateProjectUseCase {
    private final ProjectPort port;

    public UpdateProjectUseCase(ProjectPort port) {
        this.port = port;
    }

    public ProjectEntity invoke(UUID uuid, UpdateProjectRequest request) {
        return port.update(new ProjectEntity(request.getName(), uuid));
    }
}
