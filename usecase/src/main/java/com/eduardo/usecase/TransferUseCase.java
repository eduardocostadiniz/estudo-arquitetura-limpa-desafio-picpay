package com.eduardo.usecase;

import com.eduardo.core.domain.Transaction;

import java.math.BigDecimal;

public interface TransferUseCase {

    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value);

}
