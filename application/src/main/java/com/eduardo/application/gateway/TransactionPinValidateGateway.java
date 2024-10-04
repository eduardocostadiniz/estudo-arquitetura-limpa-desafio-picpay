package com.eduardo.application.gateway;

import com.eduardo.core.domain.TransactionPin;

public interface TransactionPinValidateGateway {

    Boolean validate(TransactionPin transactionPin);

}
