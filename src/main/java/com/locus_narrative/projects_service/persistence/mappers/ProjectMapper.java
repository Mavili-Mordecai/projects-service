package com.locus_narrative.projects_service.persistence.mappers;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {
    public ProjectEntity toEntity(ProjectModel model) {
        return new ProjectEntity(
                model.getId(),
                model.getName(),
                model.getUuid(),
                model.getCreatedAt(),
                model.getUpdatedAt()
        );
    }

    public ProjectModel toModel(ProjectEntity entity) {
        return ProjectModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .uuid(entity.getUuid())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public List<ProjectEntity> toEntityList(Collection<ProjectModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
