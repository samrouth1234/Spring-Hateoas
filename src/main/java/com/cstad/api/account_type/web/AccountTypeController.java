package com.cstad.api.account_type.web;

import com.cstad.api.account_type.AccountType;
import com.cstad.api.base.BaseRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeController {

    private final AccountTypeRepository accountTypeRepository;

    @GetMapping
    public BaseRest<?> getAllAccountType(){
        List<AccountType> accountTypes =accountTypeRepository.findAll();
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("AccountTypes types have been found")
                .timestamp(LocalDateTime.now())
                .data(accountTypes)
                .build();
    }

    @GetMapping("/{id}")
    public BaseRest<?> getAccountTypeById(@PathVariable Long id){
        Optional <AccountType> accountTypes =accountTypeRepository.findById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Find Account By Id types have been found")
                .timestamp(LocalDateTime.now())
                .data(accountTypes)
                .build();
    }

}
