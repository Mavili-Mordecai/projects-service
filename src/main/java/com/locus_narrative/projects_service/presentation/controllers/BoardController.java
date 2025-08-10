package com.locus_narrative.projects_service.presentation.controllers;

import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;
import com.locus_narrative.projects_service.application.dto.requests.boards.CreateBoardRequest;
import com.locus_narrative.projects_service.application.dto.requests.boards.UpdateBoardRequest;
import com.locus_narrative.projects_service.application.usecases.boards.CreateBoardUseCase;
import com.locus_narrative.projects_service.application.usecases.boards.DeleteBoardUseCase;
import com.locus_narrative.projects_service.application.usecases.boards.UpdateBoardUseCase;
import com.locus_narrative.projects_service.application.usecases.projectUsers.EnsureUserHasRoleInProjectUseCase;
import com.locus_narrative.projects_service.domain.entities.BoardEntity;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;
import com.locus_narrative.projects_service.domain.ports.BoardPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Boards")
@RestController
@RequestMapping("/projects/{projectUuid}/boards")
@RequiredArgsConstructor
public class BoardController extends BaseController {

    private final CreateBoardUseCase createBoardUseCase;
    private final UpdateBoardUseCase updateBoardUseCase;
    private final DeleteBoardUseCase deleteBoardUseCase;

    private final EnsureUserHasRoleInProjectUseCase ensureUserHasRoleInProjectUseCase;

    @PutMapping
    private ResponseEntity<Response<?>> create(@RequestBody @Validated(CreateBoardRequest.class) CreateBoardRequest request,
                                               @PathVariable("projectUuid") UUID projectUuid){
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid,getUserUuid(), ProjectUserRole.MODERATOR);

        BoardEntity entity = createBoardUseCase.invoke(projectUuid, request);

        return ResponseEntity.ok(Responses.ok(entity));
    }

    @DeleteMapping("/{boardId}")
    private ResponseEntity<Response<?>> delete( @PathVariable("projectUuid") UUID projectUuid,@PathVariable Long id){
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid,getUserUuid(), ProjectUserRole.MODERATOR);

        deleteBoardUseCase.invoke(id);

        return ResponseEntity.ok(Responses.ok());
    }

    @PatchMapping("/{boardId}")
    private ResponseEntity<Response<?>> update(@RequestBody @Validated(UpdateBoardRequest.class) UpdateBoardRequest request,
                                               @PathVariable("projectUuid") UUID projectUuid,@PathVariable Long id) {
        ensureUserHasRoleInProjectUseCase.invoke(projectUuid,getUserUuid(), ProjectUserRole.MODERATOR);

        BoardEntity entity =  updateBoardUseCase.invoke(id, request);

        return ResponseEntity.ok(Responses.ok(entity));
    }
}
