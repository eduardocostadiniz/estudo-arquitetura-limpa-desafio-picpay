package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.FindWalletByTaxNumberGateway;
import com.eduardo.core.domain.Wallet;
import com.eduardo.core.exception.NotFoundException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;
import com.eduardo.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) {
        Wallet wallet = this.findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);

        if (wallet == null) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }

        return wallet;
    }
}
