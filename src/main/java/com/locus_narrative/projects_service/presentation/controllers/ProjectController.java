package com.locus_narrative.projects_service.presentation.controllers;

import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;
import com.locus_narrative.projects_service.application.dto.requests.projects.CreateProjectRequest;
import com.locus_narrative.projects_service.application.dto.requests.projects.UpdateProjectRequest;
import com.locus_narrative.projects_service.application.usecases.projectUsers.GetUserRoleInProjectUseCase;
import com.locus_narrative.projects_service.application.usecases.projects.*;
import com.locus_narrative.projects_service.domain.entities.ProjectEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import com.locus_narrative.projects_service.domain.exceptions.AccessDeniedException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Projects", description = "Project management.")
@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController extends BaseController {
    private final CreateProjectUseCase createProjectUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;
    private final GetProjectByUuidUseCase getProjectByUuidUseCase;
    private final GetAllProjectsByOwnerUseCase getAllProjectsByOwnerUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;

    private final GetUserRoleInProjectUseCase getUserRoleInProjectUseCase;

    @PutMapping
    private ResponseEntity<Response<?>> create(@RequestBody @Validated(CreateProjectRequest.class) CreateProjectRequest request) {
        UUID principalUuid = getUserUuid();

        return ResponseEntity.status(HttpStatus.CREATED).body(Responses.created(createProjectUseCase.invoke(principalUuid, request)));
    }

    @PatchMapping("/{projectUuid}")
    private ResponseEntity<Response<?>> update(@PathVariable("projectUuid") UUID projectUuid, @RequestBody @Validated(UpdateProjectRequest.class) UpdateProjectRequest request) {
        UUID principalUuid = getUserUuid();

        ProjectUserEntity projectUser = getUserRoleInProjectUseCase.invoke(projectUuid, principalUuid);
        if (projectUser.getRole() != ProjectUserRole.OWNER) throw new AccessDeniedException();

        ProjectEntity entity = updateProjectUseCase.invoke(projectUuid, request);
        return ResponseEntity.ok(Responses.ok(entity));
    }

    @DeleteMapping("/{projectUuid}")
    private ResponseEntity<Response<?>> delete(@PathVariable("projectUuid") UUID projectUuid) {
        UUID principalUuid = getUserUuid();

        ProjectUserEntity projectUser = getUserRoleInProjectUseCase.invoke(projectUuid, principalUuid);
        if (projectUser.getRole() != ProjectUserRole.OWNER) throw new AccessDeniedException();

        deleteProjectUseCase.invoke(projectUuid);
        return ResponseEntity.ok(Responses.ok());

    }

    @GetMapping("/{projectUuid}")
    private ResponseEntity<Response<?>> getByUuid(@PathVariable("projectUuid") UUID projectUuid) {
        UUID principalUuid = getUserUuid();

        getUserRoleInProjectUseCase.invoke(projectUuid, principalUuid);

        ProjectEntity project = getProjectByUuidUseCase.invoke(projectUuid);
        return ResponseEntity.ok(Responses.ok(project));
    }

    @GetMapping
    private ResponseEntity<Response<?>> getAllByOwner() {
        UUID principalUuid = getUserUuid();

        return ResponseEntity.ok(Responses.ok(getAllProjectsByOwnerUseCase.invoke(principalUuid)));
    }
}