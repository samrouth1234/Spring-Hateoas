package com.cstad.api.account.web;

import com.cstad.api.account_type.AccountType;
import lombok.Data;

public record CreateAccountDto ( String accountName,
                                 String accountNo,
                                 String pin,
                                 Integer transferLimit,
                                 String uuid,
                                 AccountType accountType) {


}
