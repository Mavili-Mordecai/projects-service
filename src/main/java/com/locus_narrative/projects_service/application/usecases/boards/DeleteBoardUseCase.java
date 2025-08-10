package com.locus_narrative.projects_service.application.usecases.boards;

import com.locus_narrative.projects_service.domain.ports.BoardPort;

public class DeleteBoardUseCase {
    private final BoardPort port;

    public DeleteBoardUseCase(BoardPort port) {this.port = port;}

    public void invoke(Long id){ port.delete(id); }

}
