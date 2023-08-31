package com.cstad.api.transation;

import com.cstad.api.account.Account;
import com.cstad.api.account.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

@Service
public class TransactionServiceImp implements TransactionService{

    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void Transaction(Long fromAccountId, Long toAccountId, BigDecimal amount) throws AccountNotFoundException {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("From Account not found"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("To Account not found"));

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new AccountNotFoundException("Insufficient balance in the From Account");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }


}
