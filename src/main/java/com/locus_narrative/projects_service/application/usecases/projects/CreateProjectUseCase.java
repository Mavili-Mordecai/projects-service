package com.locus_narrative.projects_service.application.usecases.projects;

import com.locus_narrative.projects_service.application.dto.requests.projects.CreateProjectRequest;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;

import java.util.UUID;

public class CreateProjectUseCase {
    private final ProjectPort port;

    public CreateProjectUseCase(ProjectPort port) {
        this.port = port;
    }

    public ProjectEntity invoke(UUID ownedUuid, CreateProjectRequest request) {
        ProjectEntity project = port.insert(
                new ProjectEntity(request.getName(), UUID.randomUUID()),
                ownedUuid
        );

        return project;
    }
}
