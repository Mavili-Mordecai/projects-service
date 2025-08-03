package com.locus_narrative.projects_service.domain.ports;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;

import java.util.List;
import java.util.UUID;

public interface ProjectPort {
    ProjectEntity insert(ProjectEntity project, UUID ownerUuid);
    ProjectEntity update(ProjectEntity project);
    List<ProjectEntity> getAllByOwnerUuid(UUID userUuid);
    ProjectEntity getByUuid(UUID uuid);
    void delete(UUID uuid);
}
