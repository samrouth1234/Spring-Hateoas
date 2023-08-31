package com.cstad.api.account_type.web;

import com.cstad.api.account_type.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeController {

    private final AccountTypeRepository accountTypeRepository;

    @GetMapping
    public ResponseEntity<List<AccountType>> getAllAccountTypes() {
        List<AccountType> accountTypes = accountTypeRepository.findAll();
        return ResponseEntity.ok(accountTypes);
    }

    @GetMapping("/{id}")
    public Optional<AccountType> getAccountTypeById(@PathVariable Long id){
        Optional <AccountType> accountTypes =accountTypeRepository.findById(id);
        return accountTypes;
    }

}
