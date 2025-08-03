package com.locus_narrative.projects_service.infrastructure.config.usecases;

import com.locus_narrative.projects_service.application.usecases.projectUsers.*;
import com.locus_narrative.projects_service.domain.ports.ProjectUserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectUserUseCasesConfig {
    @Bean
    public AddUserToProjectUseCase addUserToProjectUseCase(ProjectUserPort port) {
        return new AddUserToProjectUseCase(port);
    }

    @Bean
    public GetUserRoleInProjectUseCase getUserRoleInProjectUseCase(ProjectUserPort port) {
        return new GetUserRoleInProjectUseCase(port);
    }

    @Bean
    public GetUsersInProjectUseCase getUsersInProjectUseCase(ProjectUserPort port) {
        return new GetUsersInProjectUseCase(port);
    }

    @Bean
    public RemoveUserFromProjectUseCase removeUserFromProjectUseCase(ProjectUserPort port) {
        return new RemoveUserFromProjectUseCase(port);
    }

    @Bean
    public UpdateUserRoleInProjectUseCase updateUserRoleInProjectUseCase(ProjectUserPort port) {
        return new UpdateUserRoleInProjectUseCase(port);
    }

    @Bean
    public EnsureUserHasRoleInProjectUseCase ensureUserHasRoleInProjectUseCase(GetUserRoleInProjectUseCase getUserRoleInProjectUseCase) {
        return new EnsureUserHasRoleInProjectUseCase(getUserRoleInProjectUseCase);
    }
}
