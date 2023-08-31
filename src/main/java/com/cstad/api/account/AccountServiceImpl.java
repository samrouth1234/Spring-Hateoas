package com.cstad.api.account;

import com.cstad.api.account.web.AccountModelAssembler;
import com.cstad.api.account.web.CreateAccountDto;
import com.cstad.api.account.web.UpdateAccountDto;
import com.cstad.api.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    private final AccountModelAssembler accountModelAssembler;

    private final AccountMapper accountMapper;

    @Override
    public CollectionModel<?> findAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);
    }

    @Override
    public EntityModel<?> findByUuid(String uuid) {
        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        return accountModelAssembler.toModel(account);
    }

    @Override
    public EntityModel<?> crateNewAccount(CreateAccountDto createAccountDto) {

        Account account = accountMapper.createUserDtoToUser(createAccountDto);

        account.setAccountName(createAccountDto.accountName());
        account.setAccountNo(createAccountDto.accountNo());
        account.setPin(createAccountDto.pin());
        account.setTransferLimit(createAccountDto.transferLimit());
        account.setUuid(createAccountDto.uuid());
        account.setUuid(UUID.randomUUID().toString());

        accountRepository.save(account);

        return accountModelAssembler.toModel(account);
    }

    @Transactional
    @Override
    public String closeByUuid(String uuid) {
        Optional<Account> optionalUser = accountRepository.findByUuid(uuid);
        if (optionalUser.isPresent()) {
            Account account = optionalUser.get();
            account.setAccountNo(account.getAccountNo());
            accountRepository.save(account);
            return "User UUID :" + uuid + "is now disable";
        } else {
            return "Account with UUID: " + uuid + " not found";
        }
    }
}