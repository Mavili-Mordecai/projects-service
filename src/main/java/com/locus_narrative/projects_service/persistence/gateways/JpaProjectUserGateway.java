package com.locus_narrative.projects_service.persistence.gateways;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.exceptions.ProjectNotFoundException;
import com.locus_narrative.projects_service.domain.exceptions.ProjectUserAlreadyExistsException;
import com.locus_narrative.projects_service.domain.exceptions.ProjectUserNotFoundException;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;
import com.locus_narrative.projects_service.persistence.mappers.ProjectMapper;
import com.locus_narrative.projects_service.persistence.mappers.ProjectUserMapper;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import com.locus_narrative.projects_service.persistence.models.ProjectUserModel;
import com.locus_narrative.projects_service.persistence.repositories.JpaProjectRepository;
import com.locus_narrative.projects_service.persistence.repositories.JpaProjectUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaProjectUserGateway implements ProjectUserPort {
    private final JpaProjectUserRepository repository;
    private final JpaProjectRepository projectRepository;

    private final ProjectUserMapper mapper;
    private final ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectUserEntity insert(ProjectUserEntity entity) {
        Optional<ProjectModel> projectModel = projectRepository.findByUuid(entity.getProject().getUuid());
        if (projectModel.isEmpty()) throw new ProjectNotFoundException();

        Optional<ProjectUserModel> projectUserModel = repository.findByProjectUuidAndUserUuid(projectModel.get().getUuid(), entity.getUserUuid());
        if (projectUserModel.isPresent()) throw new ProjectUserAlreadyExistsException();

        entity.setProject(projectMapper.toEntity(projectModel.get()));
        entity.setCreatedAt(LocalDateTime.now());

        return mapper.toEntity(repository.save(mapper.toModel(entity)));
    }

    @Override
    @Transactional
    public ProjectUserEntity update(ProjectUserEntity entity) {
        Optional<ProjectUserModel> model = repository.findByProjectUuidAndUserUuid(
                entity.getProject().getUuid(),
                entity.getUserUuid()
        );

        if (model.isEmpty())
            throw new ProjectUserNotFoundException("Project or user in the project not found.");

        if (entity.getRole() != null)
            model.get().setRole(entity.getRole());

        return mapper.toEntity(model.get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectUserEntity> getAllInProject(UUID projectUuid) {
        return mapper.toEntityList(repository.findAllByProjectUuid(projectUuid));
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectUserEntity getByProjectAndUser(UUID projectUuid, UUID userUuid) {
        Optional<ProjectUserModel> model = repository.findByProjectUuidAndUserUuid(
                projectUuid,
                userUuid
        );

        if (model.isEmpty())
            throw new ProjectUserNotFoundException("Project or user in the project not found.");

        return mapper.toEntity(model.get());
    }

    @Override
    @Transactional
    public void delete(UUID projectUuid, UUID userUuid) {
        Optional<ProjectUserModel> model = repository.findByProjectUuidAndUserUuid(projectUuid, userUuid);

        if (model.isEmpty())
            throw new ProjectUserNotFoundException("Project or user in the project not found.");

        repository.delete(model.get());
    }
}
