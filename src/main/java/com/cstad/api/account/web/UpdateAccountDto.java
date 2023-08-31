package com.cstad.api.account.web;

import com.cstad.api.account_type.AccountType;

public record UpdateAccountDto(String accountName,
                               String accountNo,
                               String pin,
                               Integer transferLimit,
                               String uuid,
                               Boolean status) {
}
