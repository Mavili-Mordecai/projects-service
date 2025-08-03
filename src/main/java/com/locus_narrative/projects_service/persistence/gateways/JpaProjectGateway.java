package com.locus_narrative.projects_service.persistence.gateways;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import com.locus_narrative.projects_service.domain.exceptions.ProjectNotFoundException;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;
import com.locus_narrative.projects_service.persistence.mappers.ProjectMapper;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import com.locus_narrative.projects_service.persistence.models.ProjectUserModel;
import com.locus_narrative.projects_service.persistence.repositories.JpaProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaProjectGateway implements ProjectPort {
    private final JpaProjectRepository repository;
    private final ProjectMapper mapper;

    @Override
    @Transactional
    public ProjectEntity insert(ProjectEntity project, UUID ownerUuid) {
        ProjectModel model = mapper.toModel(project);

        if (model.getUsers() == null) model.setUsers(new ArrayList<>());
        model.getUsers().add(
                ProjectUserModel.builder()
                        .project(model)
                        .role(ProjectUserRole.OWNER)
                        .userUuid(ownerUuid)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return mapper.toEntity(repository.save(model));
    }

    @Override
    @Transactional
    public ProjectEntity update(ProjectEntity project) {
        Optional<ProjectModel> model = repository.findByUuid(project.getUuid());

        if (model.isEmpty()) throw new ProjectNotFoundException();

        model.get().setName(project.getName());
        model.get().setUpdatedAt(LocalDateTime.now());

        return mapper.toEntity(repository.save(model.get()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectEntity> getAllByOwnerUuid(UUID userUuid) {
        return mapper.toEntityList(repository.findAllByOwnerUuid(userUuid));
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectEntity getByUuid(UUID uuid) {
        Optional<ProjectModel> model = repository.findByUuid(uuid);

        if (model.isEmpty()) throw new ProjectNotFoundException();

        return mapper.toEntity(model.get());
    }

    @Override
    @Transactional
    public void delete(UUID uuid) {
        Optional<ProjectModel> model = repository.findByUuid(uuid);

        if (model.isEmpty()) throw new ProjectNotFoundException();

        repository.delete(model.get());
    }
}
