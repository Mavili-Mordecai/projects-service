package com.locus_narrative.projects_service.application.usecases.projectUsers;

import com.locus_narrative.projects_service.application.dto.requests.projectUsers.ProjectUserRequest;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;

import java.util.UUID;

public class UpdateUserRoleInProjectUseCase {
    private final ProjectUserPort port;

    public UpdateUserRoleInProjectUseCase(ProjectUserPort port) {
        this.port = port;
    }

    public ProjectUserEntity invoke(UUID projectUuid, ProjectUserRequest request) {
        return port.update(
                new ProjectUserEntity(
                        new ProjectEntity(projectUuid),
                        request.getUserUuid(),
                        request.getRole()
                )
        );
    }
}