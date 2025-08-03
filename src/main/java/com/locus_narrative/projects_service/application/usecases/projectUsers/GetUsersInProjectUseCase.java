package com.locus_narrative.projects_service.application.usecases.projectUsers;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;

import java.util.List;
import java.util.UUID;

public class GetUsersInProjectUseCase {
    private final ProjectUserPort port;

    public GetUsersInProjectUseCase(ProjectUserPort port) {
        this.port = port;
    }

    public List<ProjectUserEntity> invoke(UUID projectUuid) {
        return port.getAllInProject(projectUuid);
    }
}
