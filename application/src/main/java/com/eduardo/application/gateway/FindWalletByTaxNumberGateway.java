package com.eduardo.application.gateway;

import com.eduardo.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {

    Wallet findByTaxNumber(String taxNumber);

}
