package com.eduardo.infrastructure.service;

import com.eduardo.application.gateway.CreateUserGateway;
import com.eduardo.core.domain.User;
import com.eduardo.core.domain.Wallet;
import com.eduardo.infrastructure.mapper.TransactionPinMapper;
import com.eduardo.infrastructure.mapper.UserMapper;
import com.eduardo.infrastructure.mapper.WalletMapper;
import com.eduardo.infrastructure.repository.TransactionPinEntityRepository;
import com.eduardo.infrastructure.repository.UserEntityRepository;
import com.eduardo.infrastructure.repository.WalletEntityRepository;
import org.springframework.stereotype.Service;

import static com.eduardo.infrastructure.utils.Utilities.log;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private TransactionPinEntityRepository transactionPinEntityRepository;
    private TransactionPinMapper transactionPinMapper;
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper, TransactionPinEntityRepository transactionPinEntityRepository, TransactionPinMapper transactionPinMapper, WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.transactionPinMapper = transactionPinMapper;
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Boolean create(User user, Wallet wallet) {
        try {
            log.info("Inicio da criação do usuário::CreateUserGatewayImpl");
            var userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            var transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWalletEntity(wallet, userSaved, transactionPinSaved));
            log.info("Usuário criado com sucesso::CreateUserGatewayImpl");
            return true;
        } catch (Exception e) {
            log.error("Houve um erro na criação do usuário::CreateUserGatewayImpl");
            return false;
        }

    }
}