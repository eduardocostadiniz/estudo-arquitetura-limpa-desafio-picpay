package com.eduardo.application.usecaseimpl;

import com.eduardo.application.gateway.TaxNumberAvailableGateway;
import com.eduardo.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return this.taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
