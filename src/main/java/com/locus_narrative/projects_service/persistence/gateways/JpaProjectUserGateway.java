package com.locus_narrative.projects_service.persistence.gateways;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.exceptions.ProjectUserNotFoundException;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;
import com.locus_narrative.projects_service.persistence.mappers.ProjectUserMapper;
import com.locus_narrative.projects_service.persistence.models.ProjectUserModel;
import com.locus_narrative.projects_service.persistence.repositories.JpaProjectUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaProjectUserGateway implements ProjectUserPort {
    private final JpaProjectUserRepository repository;
    private final ProjectUserMapper mapper;

    @Override
    @Transactional
    public ProjectUserEntity insert(ProjectUserEntity entity) {
        return mapper.toEntity(repository.save(mapper.toModel(entity)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectUserEntity> getAllByProjectUuid(UUID projectUuid) {
        return mapper.toEntityList(repository.findAllByProjectUuid(projectUuid));
    }

    @Override
    @Transactional
    public void delete(UUID projectUuid, UUID userUuid) throws ProjectUserNotFoundException {
        Optional<ProjectUserModel> model = repository.findByProjectUuidAndUserUuid(projectUuid, userUuid);

        if (model.isEmpty()) throw new ProjectUserNotFoundException("Project or user in the project not found.");

        repository.delete(model.get());
    }
}
