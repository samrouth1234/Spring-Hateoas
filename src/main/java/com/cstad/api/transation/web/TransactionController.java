package com.cstad.api.transation.web;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRepository repository;
    @Transactional
    @PostMapping
    public ResponseEntity<String> transferFunds(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam BigDecimal amount) {
        repository.transferFunds(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("*Sender account id:"+fromAccountId
                +" *Receiver account id:"+toAccountId+" *amount is:"+amount);
    }
}
