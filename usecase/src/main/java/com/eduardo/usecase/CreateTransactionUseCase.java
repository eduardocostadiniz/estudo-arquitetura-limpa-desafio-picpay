package com.eduardo.usecase;

import com.eduardo.core.domain.Transaction;

public interface CreateTransactionUseCase {

    Transaction create(Transaction transaction);

}
