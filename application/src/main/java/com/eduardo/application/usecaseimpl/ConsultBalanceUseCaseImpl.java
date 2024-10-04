package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.ConsultBalanceGateway;
import com.eduardo.core.domain.Wallet;
import com.eduardo.usecase.ConsultBalanceUseCase;

import java.math.BigDecimal;

public class ConsultBalanceUseCaseImpl implements ConsultBalanceUseCase {

    private final ConsultBalanceGateway consultBalanceGateway;

    public ConsultBalanceUseCaseImpl(ConsultBalanceGateway consultBalanceGateway) {
        this.consultBalanceGateway = consultBalanceGateway;
    }

    @Override
    public BigDecimal consult(Wallet wallet) {
        return this.consultBalanceGateway.consult(wallet);
    }
}
