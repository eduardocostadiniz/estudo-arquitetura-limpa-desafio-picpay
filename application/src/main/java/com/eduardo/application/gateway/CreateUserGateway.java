package com.eduardo.application.gateway;

import com.eduardo.core.domain.TransactionPin;
import com.eduardo.core.domain.User;
import com.eduardo.core.domain.Wallet;

public interface CreateUserGateway {

    Boolean create(User user, Wallet wallet);

}
