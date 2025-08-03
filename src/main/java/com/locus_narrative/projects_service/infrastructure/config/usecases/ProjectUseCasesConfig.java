package com.locus_narrative.projects_service.infrastructure.config.usecases;

import com.locus_narrative.projects_service.application.usecases.projects.*;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectUseCasesConfig {
    @Bean
    public CreateProjectUseCase createProjectUseCase(ProjectPort port) {
        return new CreateProjectUseCase(port);
    }

    @Bean
    public DeleteProjectUseCase deleteProjectUseCase(ProjectPort port) {
        return new DeleteProjectUseCase(port);
    }

    @Bean
    public GetProjectByUuidUseCase getProjectByUuidUseCase(ProjectPort port) {
        return new GetProjectByUuidUseCase(port);
    }

    @Bean
    public GetAllProjectsByOwnerUseCase getProjectsByOwnerUseCase(ProjectPort port) {
        return new GetAllProjectsByOwnerUseCase(port);
    }

    @Bean
    public UpdateProjectUseCase updateProjectUseCase(ProjectPort port) {
        return new UpdateProjectUseCase(port);
    }
}
