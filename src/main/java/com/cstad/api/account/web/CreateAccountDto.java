package com.cstad.api.account.web;

import com.cstad.api.account_type.AccountType;

import java.math.BigDecimal;

public record CreateAccountDto ( String accountName,
                                 String accountNumber,
                                 String pin,
                                 BigDecimal transferLimit,
                                 String uuid
                                 ) {


}
