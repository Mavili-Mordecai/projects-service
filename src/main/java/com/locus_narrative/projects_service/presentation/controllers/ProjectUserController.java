package com.locus_narrative.projects_service.presentation.controllers;

import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;
import com.locus_narrative.projects_service.application.dto.requests.projectUsers.ProjectUserRequest;
import com.locus_narrative.projects_service.application.usecases.projectUsers.EnsureUserHasRoleInProjectUseCase;
import com.locus_narrative.projects_service.application.usecases.projectUsers.*;
import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Users in projects", description = "User management in the project.")
@RestController
@RequestMapping("/projects/{projectUuid}/users")
@RequiredArgsConstructor
public class ProjectUserController extends BaseController {
    private final AddUserToProjectUseCase addUserToProjectUseCase;
    private final GetUsersInProjectUseCase getUsersInProjectUseCase;
    private final UpdateUserRoleInProjectUseCase updateUserRoleInProjectUseCase;
    private final RemoveUserFromProjectUseCase removeUserFromProjectUseCase;

    private final GetUserRoleInProjectUseCase getUserRoleInProjectUseCase;
    private final EnsureUserHasRoleInProjectUseCase ensureUserHasRoleInProjectUseCase;

    @PutMapping
    private ResponseEntity<Response<?>> add(
            @PathParam("projectUuid") UUID projectUuid,
            @RequestBody @Validated(ProjectUserRequest.class) ProjectUserRequest request
    ) {
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid, getUserUuid(), ProjectUserRole.OWNER);

        ProjectUserEntity projectUser = addUserToProjectUseCase.invoke(projectUuid, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(Responses.created(projectUser));
    }

    @DeleteMapping("/{userUuid}")
    private ResponseEntity<Response<?>> remove(
            @PathParam("projectUuid") UUID projectUuid,
            @PathParam("userUuid") UUID userUuid
    ) {
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid, getUserUuid(), ProjectUserRole.OWNER);

        removeUserFromProjectUseCase.invoke(projectUuid, userUuid);

        return ResponseEntity.ok(Responses.ok());
    }

    @PatchMapping
    private ResponseEntity<Response<?>> update(
            @PathParam("projectUuid") UUID projectUuid,
            @RequestBody @Validated(ProjectUserRequest.class) ProjectUserRequest request
    ) {
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid, getUserUuid(), ProjectUserRole.OWNER);

        ProjectUserEntity projectUser = updateUserRoleInProjectUseCase.invoke(projectUuid, request);

        return ResponseEntity.ok(Responses.ok(projectUser));
    }

    @GetMapping
    private ResponseEntity<Response<?>> get(
            @PathParam("projectUuid") UUID projectUuid
    ) {
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid, getUserUuid(), ProjectUserRole.MEMBER);

        return ResponseEntity.ok(Responses.ok(getUsersInProjectUseCase.invoke(projectUuid)));
    }
}
