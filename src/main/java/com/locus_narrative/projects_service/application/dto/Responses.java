package com.locus_narrative.projects_service.application.dto;

public final class Responses {
    public static <T> Response<T> ok(T data) {
        return new GenericResponse<>(data, RequestStatus.OK.status());
    }

    public static Response<String> ok() {
        return new GenericResponse<>("ok", RequestStatus.OK.status());
    }

    public static <T> Response<T> created(T data) {
        return new GenericResponse<>(data, RequestStatus.CREATED.status());
    }

    public static Response<String> error(String message, int status) {
        return new GenericResponse<>(message, status);
    }

    public static Response<String> badRequest(String message) {
        return error(message, RequestStatus.BAD_REQUEST.status());
    }

    public static Response<String> notFound(String message) {
        return error(message, RequestStatus.NOT_FOUND.status());
    }

    public static Response<String> unauthorized(String message) {
        return error(message, RequestStatus.UNAUTHORIZED.status());
    }

    public static Response<String> forbidden(String message) {
        return error(message, RequestStatus.FORBIDDEN.status());
    }

    public static Response<String> conflict(String message) {
        return error(message, RequestStatus.CONFLICT.status());
    }

    public static Response<String> internalError() {
        return error("Internal server error.", RequestStatus.INTERNAL_SERVER_ERROR.status());
    }
}
