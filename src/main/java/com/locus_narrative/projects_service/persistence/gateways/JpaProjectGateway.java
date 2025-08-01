package com.locus_narrative.projects_service.persistence.gateways;

import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.exceptions.ProjectNotFoundException;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;
import com.locus_narrative.projects_service.persistence.mappers.ProjectMapper;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import com.locus_narrative.projects_service.persistence.repositories.JpaProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public ProjectEntity insert(ProjectEntity project) {
        return mapper.toEntity(repository.save(mapper.toModel(project)));
    }

    @Override
    @Transactional
    public ProjectEntity update(ProjectEntity project) throws ProjectNotFoundException {
        Optional<ProjectModel> model = repository.findByUuid(project.getUuid());

        if (model.isEmpty()) throw new ProjectNotFoundException("Project not found");

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
    public ProjectEntity getByUuid(UUID uuid) throws ProjectNotFoundException {
        Optional<ProjectModel> model = repository.findByUuid(uuid);

        if (model.isEmpty()) throw new ProjectNotFoundException("Project not found");

        return mapper.toEntity(model.get());
    }

    @Override
    @Transactional
    public void delete(UUID uuid) throws ProjectNotFoundException {
        Optional<ProjectModel> model = repository.findByUuid(uuid);

        if (model.isEmpty()) throw new ProjectNotFoundException("Project not found");

        repository.delete(model.get());
    }
}
