package com.locus_narrative.projects_service.domain.ports;

import com.locus_narrative.projects_service.domain.entities.BoardEntity;

import java.util.List;
import java.util.UUID;

public interface BoardPort {
    BoardEntity insert(UUID projectUuid, BoardEntity board);
    BoardEntity update(BoardEntity board);
    BoardEntity getById(Long id);
    void delete(Long id);
}
