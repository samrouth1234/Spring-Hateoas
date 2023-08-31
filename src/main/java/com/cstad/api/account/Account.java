package com.cstad.api.account;

import com.cstad.api.account_type.AccountType;
import com.cstad.api.user_account.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private Integer transferLimit;

    @Column(name = "act_name")
    private String accountName;

    @Column(name = "act_no")
    private String accountNo ;

    @Column(name = "pin")
    private String pin;

    @Column(unique = true,nullable = false)
    private String uuid;

    @ManyToOne
    private AccountType accountTypes;

    @OneToMany(mappedBy = "accounts")
    private List<UserAccount> userAccount;
}
