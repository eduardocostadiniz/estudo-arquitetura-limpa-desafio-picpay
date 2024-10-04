package com.eduardo.application.gateway;

import com.eduardo.core.domain.Transaction;

public interface UserNotificationGateway {

    Boolean notificate(Transaction transaction, String email);

}
