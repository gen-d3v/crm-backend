package com.crmnexus.backend.dto.response;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String errorMessage) {
}
