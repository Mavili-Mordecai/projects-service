package com.locus_narrative.projects_service.application.usecases.projects;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;

import java.util.List;
import java.util.UUID;

public class GetAllProjectsByOwnerUseCase {
    private final ProjectPort port;

    public GetAllProjectsByOwnerUseCase(ProjectPort port) {
        this.port = port;
    }

    public List<ProjectEntity> invoke(UUID ownerUuid) {
        return port.getAllByOwnerUuid(ownerUuid);
    }
}
