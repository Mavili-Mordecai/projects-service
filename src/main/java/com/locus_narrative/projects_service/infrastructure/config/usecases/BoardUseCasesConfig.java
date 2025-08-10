package com.locus_narrative.projects_service.infrastructure.config.usecases;

import com.locus_narrative.projects_service.application.usecases.boards.CreateBoardUseCase;
import com.locus_narrative.projects_service.application.usecases.boards.DeleteBoardUseCase;
import com.locus_narrative.projects_service.application.usecases.boards.UpdateBoardUseCase;
import com.locus_narrative.projects_service.domain.ports.BoardPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardUseCasesConfig {
    @Bean
    public CreateBoardUseCase createBoardUseCase(BoardPort port) {
        return new CreateBoardUseCase(port);
    }

    @Bean
    public DeleteBoardUseCase deleteBoardUseCase(BoardPort port) {
        return new DeleteBoardUseCase(port);
    }



    /*@Bean
    public GetAllBoardsByOwnerUseCase getBoardsByOwnerUseCase(BoardPort port) {
        return new GetAllBoardsByOwnerUseCase(port);
    }*/

    @Bean
    public UpdateBoardUseCase updateBoardUseCase(BoardPort port) {
        return new UpdateBoardUseCase(port);
    }
}