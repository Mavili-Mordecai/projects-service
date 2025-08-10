package com.locus_narrative.projects_service.application.usecases.boards;

import com.locus_narrative.projects_service.application.dto.requests.boards.CreateBoardRequest;
import com.locus_narrative.projects_service.domain.entities.BoardEntity;
import com.locus_narrative.projects_service.domain.ports.BoardPort;

import java.util.UUID;

public class CreateBoardUseCase {
    private final BoardPort port;

    public CreateBoardUseCase(BoardPort port) {this.port = port;}

    public BoardEntity invoke(UUID projectUuid, CreateBoardRequest request) {
        BoardEntity board = port.insert(
                projectUuid,
                new BoardEntity(request.getName())
        );
        return board;
    }
}
