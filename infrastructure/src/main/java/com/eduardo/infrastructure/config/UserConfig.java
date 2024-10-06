package com.eduardo.infrastructure.config;

import com.eduardo.application.gateway.CreateUserGateway;
import com.eduardo.application.gateway.EmailAvailableGateway;
import com.eduardo.application.gateway.TaxNumberAvailableGateway;
import com.eduardo.application.usecaseimpl.CreateUserUseCaseImpl;
import com.eduardo.application.usecaseimpl.EmailAvailableUseCaseImpl;
import com.eduardo.application.usecaseimpl.TaxNumberAvailableUseCaseImpl;
import com.eduardo.usecase.CreateUserUseCase;
import com.eduardo.usecase.EmailAvailableUseCase;
import com.eduardo.usecase.TaxNumberAvailableUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public TaxNumberAvailableUseCase taxNumberAvailableUseCase(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        return new TaxNumberAvailableUseCaseImpl(taxNumberAvailableGateway);
    }

    @Bean
    public EmailAvailableUseCase emailAvailableUseCase(EmailAvailableGateway emailAvailableGateway) {
        return new EmailAvailableUseCaseImpl(emailAvailableGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway) {
        return new CreateUserUseCaseImpl(taxNumberAvailableUseCase, emailAvailableUseCase, createUserGateway);
    }
}