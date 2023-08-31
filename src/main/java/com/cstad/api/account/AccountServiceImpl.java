package com.cstad.api.account;

import com.cstad.api.account.web.AccountModelAssembler;
import com.cstad.api.account.web.AccountRenameDto;
import com.cstad.api.account.web.AccountTranferLimitUpdate;
import com.cstad.api.account.web.CreateAccountDto;

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

        Account account = accountMapper.createAccountDtoToAccount(createAccountDto);

        account.setAccountName(createAccountDto.accountName());
        account.setAccountNo(createAccountDto.accountNo());
        account.setPin(createAccountDto.pin());
        account.setTransferLimit(createAccountDto.transferLimit());
        account.setUuid(createAccountDto.uuid());
        account.setUuid(UUID.randomUUID().toString());
        account.setAccountTypes(createAccountDto.accountType());
        accountRepository.save(account);

        return accountModelAssembler.toModel(account);
    }

    @Transactional
    @Override
    public String closeByUuid(String uuid) {
        Optional<Account> optionalUser = accountRepository.findByUuid(uuid);
        if (optionalUser.isPresent()) {
            Account account = optionalUser.get();
            account.setStatus(false);
            accountRepository.save(account);
            return "Account UUID :" + uuid + "is now disable";
        } else {
            return "Account with UUID: " + uuid + " not found";
        }
    }

    @Override
    public EntityModel<?> createAccountRename(String uuid, AccountRenameDto accountRenameDto) {
        Optional<Account> optionalAccount = accountRepository.findByUuid(uuid);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setAccountName(accountRenameDto.accountName());
            accountRepository.save(account);
            return  accountModelAssembler.toModel(account);
        }
        throw new RuntimeException("Account with this uuid is not found ");
    }

    @Override
    public EntityModel<?> createAccountUpdateTransfer(String uuid, AccountTranferLimitUpdate accountTranferLimitUpdate) {
        Optional<Account> optionalAccount = accountRepository.findByUuid(uuid);
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            account.setTransferLimit(accountTranferLimitUpdate.transferLimit());
            accountRepository.save(account);
            return  accountModelAssembler.toModel(account);
        }
        throw new RuntimeException("Account with this uuid is not found ");
    }


}
