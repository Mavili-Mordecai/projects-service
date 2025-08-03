package com.locus_narrative.projects_service.application.usecases.projects;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.exceptions.ProjectNotFoundException;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;

import java.util.UUID;

public class GetProjectByUuidUseCase {
    private ProjectPort port;

    public GetProjectByUuidUseCase(ProjectPort port) {
        this.port = port;
    }

    public ProjectEntity invoke(UUID uuid) throws ProjectNotFoundException {
        return port.getByUuid(uuid);
    }
}
