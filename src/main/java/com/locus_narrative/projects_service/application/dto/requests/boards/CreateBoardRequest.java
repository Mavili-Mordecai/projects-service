package com.locus_narrative.projects_service.application.dto.requests.boards;

import com.locus_narrative.projects_service.application.dto.Request;
import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;

import java.util.Optional;

public class CreateBoardRequest extends Request {
    private String name;

    public CreateBoardRequest() {}

    public CreateBoardRequest(String name) {
        this.name = name;
    }

    @Override
    public Optional<Response<String>> validate() {
        if (name == null || name.isBlank())
            return Optional.of(Responses.badRequest("The `name` field cannot be empty."));

        return super.validate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
