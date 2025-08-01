package com.locus_narrative.projects_service.persistence.mappers;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.persistence.models.ProjectUserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectUserMapper {
    private final ProjectMapper projectMapper;

    public ProjectUserEntity toEntity(ProjectUserModel model) {
        return new ProjectUserEntity(
                model.getId(),
                projectMapper.toEntity(model.getProject()),
                model.getUserUuid(),
                model.getRole(),
                model.getCreatedAt()
        );
    }

    public ProjectUserModel toModel(ProjectUserEntity entity) {
        return ProjectUserModel.builder()
                .id(entity.getId())
                .project(projectMapper.toModel(entity.getProject()))
                .userUuid(entity.getUserUuid())
                .role(entity.getRole())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public List<ProjectUserEntity> toEntityList(Collection<ProjectUserModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
