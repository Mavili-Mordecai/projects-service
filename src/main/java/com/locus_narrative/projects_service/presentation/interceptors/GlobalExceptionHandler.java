package com.locus_narrative.projects_service.presentation.interceptors;

import com.locus_narrative.projects_service.application.dto.Response;
import com.locus_narrative.projects_service.application.dto.Responses;
import com.locus_narrative.projects_service.domain.exceptions.ApiException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<?>> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse("Validation failed");

        return ResponseEntity
                .badRequest()
                .body(Responses.badRequest(errorMessage));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response<?>> handleValidationException(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .badRequest()
                .body(Responses.badRequest("Invalid request body."));
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Response<?>> handleApiException(ApiException ex) {
        return ResponseEntity.status(ex.getStatus()).body(Responses.error(ex.getMessage(), ex.getStatus()));
    }
}
