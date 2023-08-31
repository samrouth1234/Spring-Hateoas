package com.cstad.api.user_account;

import com.cstad.api.account.Account;
import com.cstad.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @Column(name = "create_at")
    private Timestamp createAccount;

    @Column(name = "updated_at")
    private Timestamp updatedAccount;

    @ManyToOne
    private Account accounts;

    @ManyToOne
    private User user;
}
