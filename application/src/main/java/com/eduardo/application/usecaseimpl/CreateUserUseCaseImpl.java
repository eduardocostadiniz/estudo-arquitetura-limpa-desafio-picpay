package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.CreateUserGateway;
import com.eduardo.core.domain.TransactionPin;
import com.eduardo.core.domain.User;
import com.eduardo.core.domain.Wallet;
import com.eduardo.core.exception.EmailException;
import com.eduardo.core.exception.TaxNumberException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final CreateWalletUseCase createWalletUseCase;
    private final CreateTransactionPinUseCase createTransactionPinUseCase;
    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateWalletUseCase createWalletUseCase, CreateTransactionPinUseCase createTransactionPinUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) {
        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }
        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        User userCreated = this.createUserGateway.create(user);

        this.createWalletUseCase.create(new Wallet(BigDecimal.ZERO, userCreated));
        this.createTransactionPinUseCase.create(new TransactionPin(userCreated, pin));

    }
}
