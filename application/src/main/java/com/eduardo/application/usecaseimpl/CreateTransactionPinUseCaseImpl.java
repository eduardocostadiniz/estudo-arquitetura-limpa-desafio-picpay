package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.CreateTransactionPinGateway;
import com.eduardo.core.domain.TransactionPin;
import com.eduardo.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {

    private final CreateTransactionPinGateway createTransactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        this.createTransactionPinGateway.create(transactionPin);
    }
}
