package com.cstad.api.user;

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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "one_signal_id")
    private String oneSignalId;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "student_card_no")
    private String studentCardNo;

    @Column(name = "Verified_code")
    private String verifiedCode;

    @Column(name = "email")
    private String email;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_student")
    private Boolean isStudent;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @OneToMany(mappedBy = "user")
    private List<UserAccount> userAccount;

    @OneToMany(mappedBy = "user")
    private List<UserRole> usersRole;

}