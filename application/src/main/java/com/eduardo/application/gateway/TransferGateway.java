package com.eduardo.application.gateway;

import com.eduardo.core.domain.Transaction;

public interface TransferGateway {

    Boolean transfer(Transaction transaction);

}
