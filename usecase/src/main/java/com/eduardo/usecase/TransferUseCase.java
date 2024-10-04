package com.eduardo.usecase;

import com.eduardo.core.domain.Transaction;

public interface TransferUseCase {

    Boolean transfer(Transaction transaction);

}
