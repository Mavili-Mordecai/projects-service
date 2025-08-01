package com.locus_narrative.projects_service.domain.ports;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.exceptions.ProjectNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProjectPort {
    ProjectEntity insert(ProjectEntity project);
    ProjectEntity update(ProjectEntity project) throws ProjectNotFoundException;
    List<ProjectEntity> getAllByOwnerUuid(UUID userUuid);
    ProjectEntity getByUuid(UUID uuid) throws ProjectNotFoundException;
    void delete(UUID uuid) throws ProjectNotFoundException;
}
