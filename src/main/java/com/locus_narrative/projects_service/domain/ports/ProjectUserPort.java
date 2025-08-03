package com.locus_narrative.projects_service.domain.ports;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.exceptions.ProjectUserNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProjectUserPort {
    ProjectUserEntity insert(ProjectUserEntity entity);
    ProjectUserEntity update(ProjectUserEntity entity) throws ProjectUserNotFoundException;
    List<ProjectUserEntity> getAllInProject(UUID projectUuid);
    ProjectUserEntity getByProjectAndUser(UUID projectUuid, UUID userUuid) throws ProjectUserNotFoundException;
    void delete(UUID projectUuid, UUID userUuid) throws ProjectUserNotFoundException;
}
