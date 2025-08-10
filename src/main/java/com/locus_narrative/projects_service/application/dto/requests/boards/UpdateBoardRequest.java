package com.locus_narrative.projects_service.application.dto.requests.boards;

import com.locus_narrative.projects_service.application.dto.Request;
import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;

import java.util.Optional;
import java.util.stream.Stream;

public class UpdateBoardRequest extends Request {
    private String name;

    public UpdateBoardRequest() {
    }

    public UpdateBoardRequest(String name) {
        this.name = name;
    }

    @Override
    public Optional<Response<String>> validate() {
        if (isAllFieldsNotFilled())
            return Optional.of(Responses.badRequest("At least one field must be filled in."));

        return super.validate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isAllFieldsNotFilled() {
        return Stream.of(name)
                .allMatch(it ->
                        it == null || (it instanceof String && ((String) it).isBlank())
                );
    }
}
