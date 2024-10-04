package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.TransferGateway;
import com.eduardo.core.domain.Transaction;
import com.eduardo.core.domain.Wallet;
import com.eduardo.core.exception.InternalServerErrorException;
import com.eduardo.core.exception.NotificationException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final UserNotificationUseCase userNotificationUseCase;
    private final TransactionPinValidateUseCase transactionPinValidateUseCase;
    private final TransferGateway transferGateway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, UserNotificationUseCase userNotificationUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value, String pin) {
        Wallet from = this.findWalletByTaxNumberUseCase.findWalletByTaxNumber(fromTaxNumber);
        Wallet to = this.findWalletByTaxNumberUseCase.findWalletByTaxNumber(toTaxNumber);

        this.transactionPinValidateUseCase.validate(from.getTransactionPin());

        from.transferValue(value);
        to.receiveValue(value);

        Transaction transaction = this.createTransactionUseCase.create(new Transaction(from, to, value));

        this.transactionValidateUseCase.validate(transaction);

        if (!this.transferGateway.transfer(transaction)) {
            throw new InternalServerErrorException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!this.userNotificationUseCase.notificate(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return true;
    }
}
