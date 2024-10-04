package com.eduardo.application.gateway;

import com.eduardo.core.domain.Transaction;

public interface TransactionValidateGateway {

    Boolean validate(Transaction transaction);

}
