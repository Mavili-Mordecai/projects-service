package com.locus_narrative.projects_service.application.usecases.projects;

import com.locus_narrative.projects_service.domain.ports.ProjectPort;

import java.util.UUID;

public class DeleteProjectUseCase {
    private final ProjectPort port;

    public DeleteProjectUseCase(ProjectPort port) {
        this.port = port;
    }

    public void invoke(UUID uuid) {
        port.delete(uuid);
    }
}
