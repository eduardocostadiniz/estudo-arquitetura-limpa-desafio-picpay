package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.CreateTransactionGateway;
import com.eduardo.core.domain.Transaction;
import com.eduardo.core.exception.TransferException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.CreateTransactionUseCase;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) {
        Transaction transactionCreated = this.createTransactionGateway.create(transaction);

        if (transactionCreated == null) {
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }
        return transactionCreated;
    }
}
