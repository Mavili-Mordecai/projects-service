package com.locus_narrative.projects_service.infrastructure.config.usecases;

import com.locus_narrative.projects_service.application.usecases.projects.*;
import com.locus_narrative.projects_service.domain.ports.ProjectPort;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectUseCasesConfig {
    @Bean
    public CreateProjectUseCase createProjectUseCase(ProjectPort port, ProjectUserPort projectUserPort) {
        return new CreateProjectUseCase(port, projectUserPort);
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
    public GetProjectsByOwnerUseCase getProjectsByOwnerUseCase(ProjectPort port) {
        return new GetProjectsByOwnerUseCase(port);
    }

    @Bean
    public UpdateProjectUseCase updateProjectUseCase(ProjectPort port) {
        return new UpdateProjectUseCase(port);
    }
}
