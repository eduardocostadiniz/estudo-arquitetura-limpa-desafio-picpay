package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.TransactionPinValidateGateway;
import com.eduardo.core.domain.TransactionPin;
import com.eduardo.core.exception.TransactionPinException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.TransactionPinValidateUseCase;
import com.eduardo.usecase.UpdateTransactionPinUseCase;

public class TransactionPinValidateUseCaseImpl implements TransactionPinValidateUseCase {

    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;
    private final TransactionPinValidateGateway transactionPinValidateGateway;

    public TransactionPinValidateUseCaseImpl(UpdateTransactionPinUseCase updateTransactionPinUseCase, TransactionPinValidateGateway transactionPinValidateGateway) {
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
        this.transactionPinValidateGateway = transactionPinValidateGateway;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) {

        if (transactionPin.getBlocked()) {
            throw new TransactionPinException(ErrorCodeEnum.TP0002.getMessage(), ErrorCodeEnum.TP0002.getCode());
        }

        if (!this.transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            TransactionPin transactionPinUpdated = this.updateTransactionPinUseCase.update(transactionPin);
            throw new TransactionPinException(String.format(ErrorCodeEnum.TP0003.getMessage(), transactionPinUpdated.getAttempt()), ErrorCodeEnum.TP0003.getCode());
        }

        if (transactionPin.getAttempt() < 3) {
            transactionPin.resetAttempts();
            this.updateTransactionPinUseCase.update(transactionPin);
        }

        return true;
    }
}
