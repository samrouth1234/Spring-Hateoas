package com.cstad.api.user;

import com.cstad.api.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_at")
    private Timestamp createAccount;

    @Column(name = "updated_at")
    private Timestamp updatedAccount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;
}
