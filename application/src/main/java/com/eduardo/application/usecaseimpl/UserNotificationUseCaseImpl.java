package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.UserNotificationGateway;
import com.eduardo.core.domain.Transaction;
import com.eduardo.usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase {

    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return null;
    }
}
