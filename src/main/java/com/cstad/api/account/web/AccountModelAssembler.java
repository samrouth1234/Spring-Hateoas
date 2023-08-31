package com.cstad.api.account.web;

import com.cstad.api.account.Account;
import com.cstad.api.account.AccountMapper;
import com.cstad.api.user.web.UserController;
import com.cstad.api.user.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {

    private AccountMapper accountMapper;

    @Autowired
    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @SuppressWarnings("unchecked")
    public AccountModelAssembler() {
        super(AccountController.class,(Class<EntityModel<AccountDto>>) (Class<?>) EntityModel.class );
    }


    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapper.mapAccountToAccountDto(entity);
        // add link
        Link selflink= linkTo(methodOn(AccountController.class).getUser(entity.getUuid())).withSelfRel();
        Link collectionLink= linkTo(methodOn(AccountController.class).getAllUsers()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(accountDto,selflink,collectionLink);
    }
    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }
}
