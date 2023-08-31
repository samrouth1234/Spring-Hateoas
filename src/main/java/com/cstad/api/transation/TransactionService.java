package com.cstad.api.transation;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface TransactionService {
    void Transaction(Long fromAccountId, Long toAccountId, BigDecimal amount) throws AccountNotFoundException;
}
