package com.cstad.api.account;

import com.cstad.api.account.web.CreateAccountDto;
import com.cstad.api.account.web.UpdateAccountDto;
import com.cstad.api.user.web.UpdateUserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    CollectionModel<?> findAllAccount();
    EntityModel<?> findByUuid(String uuid);

    EntityModel<?> crateNewAccount(CreateAccountDto createAccountDto);

    String closeByUuid (String uuid);
}