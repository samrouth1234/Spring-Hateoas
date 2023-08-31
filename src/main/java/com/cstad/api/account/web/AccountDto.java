package com.cstad.api.account.web;

public record AccountDto(String accountName,
                         String accountNo ,
                         String pin,
                         Integer transferLimit,
                         String uuid ) {
}
