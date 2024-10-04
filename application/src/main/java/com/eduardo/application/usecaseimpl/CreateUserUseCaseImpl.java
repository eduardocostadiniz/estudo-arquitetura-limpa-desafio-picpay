package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.CreateUserGateway;
import com.eduardo.core.domain.TransactionPin;
import com.eduardo.core.domain.User;
import com.eduardo.core.domain.Wallet;
import com.eduardo.core.exception.EmailException;
import com.eduardo.core.exception.InternalServerErrorException;
import com.eduardo.core.exception.TaxNumberException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.CreateUserUseCase;
import com.eduardo.usecase.EmailAvailableUseCase;
import com.eduardo.usecase.TaxNumberAvailableUseCase;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;
    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
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

        TransactionPin transactionPin = new TransactionPin(pin);
        Wallet wallet = new Wallet(transactionPin, BigDecimal.ZERO, user);

        if (!this.createUserGateway.create(user, wallet)) {
            throw new InternalServerErrorException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
