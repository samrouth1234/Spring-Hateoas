package com.cstad.api.user_account;

import com.cstad.api.account.Account;
import com.cstad.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

    @Column(unique = true,nullable = false)
    private String uuid;

    @Column(name = "create_at")
    private LocalDateTime createAccount;

    @Column(name = "updated_at")
    private LocalDateTime  updatedAccount;

    @ManyToOne
    private Account account;

    @ManyToOne
    private User user;

}
