package com.locus_narrative.projects_service.domain.ports;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;

import java.util.List;
import java.util.UUID;

public interface ProjectUserPort {
    ProjectUserEntity insert(ProjectUserEntity entity);
    ProjectUserEntity update(ProjectUserEntity entity);
    List<ProjectUserEntity> getAllInProject(UUID projectUuid);
    ProjectUserEntity getByProjectAndUser(UUID projectUuid, UUID userUuid);
    void delete(UUID projectUuid, UUID userUuid);
}
