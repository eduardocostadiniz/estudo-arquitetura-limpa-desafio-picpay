package com.eduardo.infrastructure.service;

import com.eduardo.application.gateway.EmailAvailableGateway;
import com.eduardo.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailAvailableGatewayImpl implements EmailAvailableGateway {
    private UserEntityRepository userEntityRepository;

    public EmailAvailableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean emailAvailable(String email) {
        return !userEntityRepository.existsByEmail(email);
    }
}