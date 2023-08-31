package com.cstad.api.account;

import com.cstad.api.account.web.AccountRenameDto;
import com.cstad.api.account.web.AccountTranferLimitUpdate;
import com.cstad.api.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    CollectionModel<?> findAllAccount();
    EntityModel<?> findByUuid(String uuid);

    EntityModel<?> crateNewAccount(CreateAccountDto createAccountDto);

    String closeByUuid (String uuid);

    EntityModel<?> createAccountRename(String uuid,AccountRenameDto accountRenameDto);

    EntityModel<?> createAccountUpdateTransfer(String uuid, AccountTranferLimitUpdate accountTranferLimitUpdate);
}
