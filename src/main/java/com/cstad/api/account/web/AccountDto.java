package com.cstad.api.account.web;

import com.cstad.api.account_type.AccountType;

public record AccountDto(String accountName,
                         String accountNumber ,
                         String pin,
                         Integer transferLimit,
                         String uuid ) {
}
