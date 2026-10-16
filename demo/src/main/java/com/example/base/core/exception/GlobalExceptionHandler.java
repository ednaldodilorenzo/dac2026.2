package com.example.base.core.exception;


import org.jspecify.annotations.Nullable;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tools.jackson.databind.exc.InvalidFormatException;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.exc.InvalidFormatException;

import java.util.Arrays;

import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(APIException.class)
    public ResponseEntity<?> handleAPIException(APIException e) {
        return switch (e.getType()) {
            case NOT_FOUND -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            case BUSINESS_ERROR -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
        };
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        ProblemDetail problem =
                ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problem.setTitle("Invalid request body");

        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException invalidFormat) {

            Class<?> targetType = invalidFormat.getTargetType();

            if (targetType != null && targetType.isEnum()) {

                String field = invalidFormat.getPath()
                        .stream()
                        .map(JacksonException.Reference::getPropertyName)
                        .filter(Objects::nonNull)
                        .collect(Collectors.joining("."));

                String allowedValues = Arrays.stream(
                                targetType.getEnumConstants()
                        )
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));

                problem.setDetail(
                        "Invalid value '%s' for field '%s'. Allowed values: %s"
                                .formatted(
                                        invalidFormat.getValue(),
                                        field,
                                        allowedValues
                                )
                );
            }
        }

        return handleExceptionInternal(
                ex,
                problem,
                headers,
                HttpStatus.BAD_REQUEST,
                request
        );
    }
}
