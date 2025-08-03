package com.locus_narrative.projects_service.application.usecases.projectUsers;

import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;

import java.util.UUID;

public class RemoveUserFromProjectUseCase {
    private final ProjectUserPort port;

    public RemoveUserFromProjectUseCase(ProjectUserPort port) {
        this.port = port;
    }

    public void invoke(UUID projectUuid, UUID userUuid) {
        port.delete(projectUuid, userUuid);
    }
}
