package com.eduardo.usecase;

import com.eduardo.core.domain.Transaction;

public interface UserNotificationUseCase {

    Boolean notificate(Transaction transaction, String email);

}
