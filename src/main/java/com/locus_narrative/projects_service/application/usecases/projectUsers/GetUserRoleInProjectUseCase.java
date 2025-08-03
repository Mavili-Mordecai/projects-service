package com.locus_narrative.projects_service.application.usecases.projectUsers;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;

import java.util.UUID;

public class GetUserRoleInProjectUseCase {
    private final ProjectUserPort port;

    public GetUserRoleInProjectUseCase(ProjectUserPort port) {
        this.port = port;
    }

    public ProjectUserEntity invoke(UUID projectUuid, UUID userUuid) {
        return port.getByProjectAndUser(projectUuid, userUuid);
    }
}
