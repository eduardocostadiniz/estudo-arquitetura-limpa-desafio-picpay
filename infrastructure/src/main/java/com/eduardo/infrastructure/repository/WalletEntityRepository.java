package com.eduardo.infrastructure.repository;

import com.eduardo.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}