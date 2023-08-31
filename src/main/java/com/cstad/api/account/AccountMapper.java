package com.cstad.api.account;

import com.cstad.api.account.web.AccountDto;
import com.cstad.api.account.web.AccountRenameDto;
import com.cstad.api.account.web.AccountTranferLimitUpdate;
import com.cstad.api.account.web.CreateAccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto mapAccountToAccountDto (Account account);

    List<AccountDto> mapAccountToAccountList (List<Account>accounts);

    Account createAccountDtoToAccount(CreateAccountDto createAccountDto);

    Account createAccountRenameDtoToAccount(AccountRenameDto accountRenameDto);

    Account createAccountUpdateTransferDtoToAccount(AccountTranferLimitUpdate accountTranferLimitUpdate);

}
