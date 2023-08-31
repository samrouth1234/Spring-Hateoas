package com.cstad.api.account_type.web;

import com.cstad.api.account_type.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {

}
