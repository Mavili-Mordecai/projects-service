package com.locus_narrative.projects_service.persistence.gateways;

import com.locus_narrative.projects_service.domain.entities.BoardEntity;
import com.locus_narrative.projects_service.domain.exceptions.BoardNotFoundException;
import com.locus_narrative.projects_service.domain.exceptions.ProjectNotFoundException;
import com.locus_narrative.projects_service.domain.ports.BoardPort;
import com.locus_narrative.projects_service.persistence.mappers.BoardMapper;
import com.locus_narrative.projects_service.persistence.models.BoardModel;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import com.locus_narrative.projects_service.persistence.repositories.JpaBoardRepository;
import com.locus_narrative.projects_service.persistence.repositories.JpaProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class JpaBoardGateway implements BoardPort {
    private final JpaBoardRepository repository;
    private final BoardMapper mapper;
    private final JpaProjectRepository projectRepository;

    @Transactional
    @Override
    public BoardEntity insert(UUID projectUuid, BoardEntity board) {
        Optional<ProjectModel> projectModel = projectRepository.findByUuid(projectUuid);

        if(projectModel.isEmpty()) throw new ProjectNotFoundException();

        BoardModel model = mapper.toModel(board);

        model.setProject(projectModel.get());

        return mapper.toEntity(repository.save(model));
    }

    @Transactional
    @Override
    public BoardEntity update(BoardEntity board) {
        Optional<BoardModel> model =  repository.findById(board.getId());

        if (model.isEmpty()) throw new BoardNotFoundException();


        model.get().setName(board.getName());

        return mapper.toEntity(repository.save(model.get()));
    }

    @Transactional(readOnly = true)
    @Override
    public BoardEntity getById(Long id) {
        Optional<BoardModel> model =  repository.findById(id);

        if (model.isEmpty()) throw new BoardNotFoundException();

        return mapper.toEntity(model.get());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Optional<BoardModel> model =  repository.findById(id);

        if (model.isEmpty()) throw new BoardNotFoundException();

        repository.delete(model.get());
    }
}
