package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.EmailAvailableGateway;
import com.eduardo.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private  final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return this.emailAvailableGateway.emailAvailable(email);
    }
}
