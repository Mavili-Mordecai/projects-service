package com.locus_narrative.projects_service.application.usecases.projectUsers;

import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import com.locus_narrative.projects_service.domain.exceptions.AccessDeniedException;

import java.util.UUID;

public class EnsureUserHasRoleInProjectUseCase {
    private final GetUserRoleInProjectUseCase getUserRoleInProjectUseCase;

    public EnsureUserHasRoleInProjectUseCase(GetUserRoleInProjectUseCase getUserRoleInProjectUseCase) {
        this.getUserRoleInProjectUseCase = getUserRoleInProjectUseCase;
    }

    public void invoke(UUID projectUuid, UUID userUuid, ProjectUserRole role) {
        ProjectUserEntity projectUser = getUserRoleInProjectUseCase.invoke(projectUuid, userUuid);

        if (projectUser.getRole().ordinal() >= role.ordinal()) return;

        throw new AccessDeniedException();
    }
}
