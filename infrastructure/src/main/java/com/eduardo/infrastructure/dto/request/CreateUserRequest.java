package com.eduardo.infrastructure.dto.request;

import com.eduardo.core.domain.enums.UserTypeEnum;

public record CreateUserRequest(String email, String password, String taxNumber, String fullname, UserTypeEnum type,
                                String pin) {
}