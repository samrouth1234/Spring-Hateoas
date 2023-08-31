package com.cstad.api.account;

import com.cstad.api.account.web.AccountDto;
import com.cstad.api.account.web.CreateAccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto mapAccountToAccountDto (Account account);

    List<AccountDto> mapAccountToAccountList (List<Account>accounts);

    Account createUserDtoToUser(CreateAccountDto createAccountDto);

}
