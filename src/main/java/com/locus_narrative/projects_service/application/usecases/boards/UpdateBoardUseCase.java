package com.locus_narrative.projects_service.application.usecases.boards;

import com.locus_narrative.projects_service.application.dto.requests.boards.UpdateBoardRequest;
import com.locus_narrative.projects_service.domain.entities.BoardEntity;
import com.locus_narrative.projects_service.domain.ports.BoardPort;

public class UpdateBoardUseCase {
    private final BoardPort port;

    public UpdateBoardUseCase(BoardPort port) {this.port = port;}

    public BoardEntity invoke(Long id,UpdateBoardRequest updateBoardRequest) {
        return  port.update(new BoardEntity(id, updateBoardRequest.getName()));
    }
}
