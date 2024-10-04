package com.eduardo.usecase;

import com.eduardo.core.domain.User;

public interface CreateUserUseCase {

    void create(User user, String pin);

}
