package com.cstad.api.account;

import com.cstad.api.account_type.AccountType;
import com.cstad.api.user_account.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transfer_limit")
    private BigDecimal transferLimit;

    @Column(name = "act_name")
    private String accountName;

    @Column(name = "act_no")
    private String accountNumber ;

    @Column(name = "pin")
    private String pin;

    @Column(unique = true,nullable = false)
    private String uuid;

    private BigDecimal balance;

    private Boolean status;

    @ManyToOne
    private AccountType accountTypes;

}
