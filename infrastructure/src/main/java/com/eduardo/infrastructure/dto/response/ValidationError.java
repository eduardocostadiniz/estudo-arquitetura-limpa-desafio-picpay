package com.eduardo.infrastructure.dto.response;

public record ValidationError(String field, String message) {
}