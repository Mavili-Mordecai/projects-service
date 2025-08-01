package com.locus_narrative.projects_service.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectUserEntity {
    private Long id = null;
    private ProjectEntity project;
    private UUID userUuid;
    private ProjectUserRole role;
    private LocalDateTime createdAt;

    public ProjectUserEntity() {}

    public ProjectUserEntity(ProjectEntity project, UUID userUuid, ProjectUserRole role) {
        this.project = project;
        this.userUuid = userUuid;
        this.role = role;
    }

    public ProjectUserEntity(Long id, ProjectEntity project, UUID userUuid, ProjectUserRole role, LocalDateTime createdAt) {
        this.id = id;
        this.project = project;
        this.userUuid = userUuid;
        this.role = role;
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectUserRole getRole() {
        return role;
    }

    public void setRole(ProjectUserRole role) {
        this.role = role;
    }
}
