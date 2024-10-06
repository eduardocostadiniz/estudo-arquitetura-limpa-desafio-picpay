package com.eduardo.infrastructure.mapper;

import com.eduardo.core.domain.Wallet;
import com.eduardo.infrastructure.entity.TransactionPinEntity;
import com.eduardo.infrastructure.entity.UserEntity;
import com.eduardo.infrastructure.entity.WalletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public WalletEntity toWalletEntity(Wallet wallet, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        return new WalletEntity(
                wallet.getBalance(),
                userEntity,
                transactionPinEntity,
                wallet.getCreatedAt(),
                wallet.getUpdatedAt()
        );
    }
}