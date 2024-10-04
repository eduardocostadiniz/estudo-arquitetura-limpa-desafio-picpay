package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.CreateWalletGateway;
import com.eduardo.core.domain.Wallet;
import com.eduardo.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void create(Wallet wallet) {
        this.createWalletGateway.create(wallet);
    }
}
