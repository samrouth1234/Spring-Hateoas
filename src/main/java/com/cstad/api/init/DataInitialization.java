package com.cstad.api.init;

import com.cstad.api.account_type.AccountType;
import com.cstad.api.account_type.web.AccountTypeRepository;
import com.cstad.api.user.User;
import com.cstad.api.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DataInitialization {
    /*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @PostConstruct
    void init(){
        System.out.println("=========== Start Application ===========");

        User user = User.builder()
                .email("bichsamrouth@gmail.com")
                .name("bich samrouth")
                .gender("Male")
                .isDeleted(true)
                .studentCardNo("0001")

                .uuid(UUID.randomUUID().toString())
                .phoneNumber("23456789")
                .studentCardNo("1")
                .build();
        User user1 = User.builder()
                .email("samrouth@gmail.com")
                .name("bich")
                .gender("Male")
                .isDeleted(true)
                .studentCardNo("0002")
                .uuid(UUID.randomUUID().toString())
                .phoneNumber("98765")
                .studentCardNo("2")
                .build();
        userRepository.saveAll(List.of(user,user1));


        AccountType accountType = AccountType
                .builder()
                .name("admin")
                .build();
        AccountType accountType1 = AccountType
                .builder()
                .name("system")
                .build();
        AccountType accountType2 = AccountType
                .builder()
                .name("customer")
                .build();
        accountTypeRepository.saveAll(List.of(accountType,accountType1,accountType2));

    }

     */

}
