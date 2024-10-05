package com.eduardo.infrastructure.repository;

import com.eduardo.infrastructure.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
