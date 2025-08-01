package com.locus_narrative.projects_service.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectEntity {
    private Long id = null;
    private String name;
    private UUID uuid;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProjectEntity() {}

    public ProjectEntity(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public ProjectEntity(Long id, String name, UUID uuid, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
