package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.UserAuthenticateGateway;
import com.eduardo.core.exception.AuthenticationException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImp implements UserAuthenticateUseCase {

    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateUseCaseImp(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) {
        if (!this.userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticationException(ErrorCodeEnum.AU0001.getMessage(), ErrorCodeEnum.AU0001.getCode());
        }
        return true;
    }
}
