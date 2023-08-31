package com.cstad.api.account.web;

import com.cstad.api.account.AccountRepository;
import com.cstad.api.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping
    public CollectionModel<?> getAllUsers(){
        return accountService.findAllAccount();
    }
    @GetMapping("/{uuid}")
    public EntityModel<?> getUser(@PathVariable String uuid){
        return accountService.findByUuid(uuid);
    }

    @PostMapping
    public EntityModel<?> createNewAccount (CreateAccountDto createAccountDto){
        return accountService.crateNewAccount(createAccountDto);
    }
    @PutMapping("/{uuid}/closes")
    public void closeByUuid( @PathVariable String uuid){
        accountService.closeByUuid(uuid);
    }
}
