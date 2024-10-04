package com.eduardo.application.gateway;

import com.eduardo.core.domain.Transaction;

public interface CreateTransactionGateway {

    Transaction create(Transaction transaction);

}
