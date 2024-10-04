package com.eduardo.usecase;

import com.eduardo.core.domain.User;

public interface FindUserByTaxNumberUseCase {

    User findUserByTaxNumber(String taxNumber);

}
