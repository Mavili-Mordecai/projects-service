package com.locus_narrative.projects_service.persistence.mappers;

import com.locus_narrative.projects_service.domain.entities.BoardEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.persistence.models.BoardModel;
import com.locus_narrative.projects_service.persistence.models.ProjectModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
public class BoardMapper {
    private final ProjectMapper projectMapper;

    public BoardEntity toEntity(BoardModel model) {
        return new BoardEntity(
                model.getId(),
                model.getName()
        );
    }

    public BoardModel toModel(BoardEntity entity) {
        return BoardModel.builder()
                .id(entity.getId())
                .name(entity.getName()).build();
    }

    public List<BoardEntity> toEntityList(Collection<BoardModel> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
