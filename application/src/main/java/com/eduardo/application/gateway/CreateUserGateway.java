package com.eduardo.application.gateway;

import com.eduardo.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
