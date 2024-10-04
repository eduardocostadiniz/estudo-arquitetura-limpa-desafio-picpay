package com.eduardo.application.gateway;

import com.eduardo.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {

    BigDecimal consult(Wallet wallet);

}
