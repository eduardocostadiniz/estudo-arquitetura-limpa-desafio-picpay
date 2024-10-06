package com.eduardo.infrastructure.service;

import com.eduardo.application.gateway.TaxNumberAvailableGateway;
import com.eduardo.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import static com.eduardo.infrastructure.utils.Utilities.log;

@Service
public class TaxNumberAvailableGatewayImpl implements TaxNumberAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public TaxNumberAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        log.info("Inicio da verificação se o TaxNumber está disponível");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}