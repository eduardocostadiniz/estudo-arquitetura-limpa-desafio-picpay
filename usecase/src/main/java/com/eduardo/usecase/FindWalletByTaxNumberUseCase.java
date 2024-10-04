package com.eduardo.usecase;

import com.eduardo.core.domain.User;
import com.eduardo.core.domain.Wallet;

public interface FindWalletByTaxNumberUseCase {

    Wallet findWalletByTaxNumber(String taxNumber);

}
