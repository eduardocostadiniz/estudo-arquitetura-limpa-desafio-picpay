package com.eduardo.usecase;

import com.eduardo.core.domain.Transaction;

public interface TransactionValidateUseCase {

    Boolean validate(Transaction transaction);

}
