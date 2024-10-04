package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.TransactionValidateGateway;
import com.eduardo.core.domain.Transaction;
import com.eduardo.core.exception.TransferException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.TransactionValidateUseCase;

public class TransactionValidateUseCaseImpl implements TransactionValidateUseCase {

    private final TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateUseCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) {
        if (!this.transactionValidateGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }
        return true;
    }
}
