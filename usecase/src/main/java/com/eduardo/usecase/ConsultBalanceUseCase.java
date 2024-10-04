package com.eduardo.usecase;

import com.eduardo.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {

    BigDecimal consult(Wallet wallet);

}
