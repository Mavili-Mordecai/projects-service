package com.locus_narrative.projects_service.application.dto.requests.projectUsers;

import com.locus_narrative.projects_service.application.dto.Request;
import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;
import com.locus_narrative.projects_service.domain.entities.ProjectUserRole;

import java.util.Optional;
import java.util.UUID;

public class ProjectUserRequest extends Request {
    private UUID userUuid;
    private ProjectUserRole role;

    public ProjectUserRequest() {

    }

    public ProjectUserRequest(UUID userUuid, ProjectUserRole role) {
        this.userUuid = userUuid;
        this.role = role;
    }

    @Override
    public Optional<Response<String>> validate() {
        if (userUuid == null)
            return Optional.of(Responses.badRequest("The `userUuid` field cannot be empty."));

        if (role == null)
            return Optional.of(Responses.badRequest("The `role` field cannot be empty."));

        return super.validate();
    }

    public ProjectUserRole getRole() {
        return role;
    }

    public void setRole(ProjectUserRole role) {
        this.role = role;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }
}
