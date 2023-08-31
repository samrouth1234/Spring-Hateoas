package com.cstad.api.transation.web;

import com.cstad.api.transation.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Transactional
    @Modifying
    @Query(value = "CALL transfer_funds(:fromAccountId, :toAccountId, :amount)", nativeQuery = true)
    void transferFunds(
            @Param("fromAccountId") Long fromAccountId,
            @Param("toAccountId") Long toAccountId,
            @Param("amount") BigDecimal amount
    );

}
