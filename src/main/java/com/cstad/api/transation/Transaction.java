package com.cstad.api.transation;

import com.cstad.api.account.Account;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")

public class Transaction {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Integer amount ;

    @Column(name = "remark")
    private String remark;

    @Column(name = "transaction_at")
    private Timestamp transactionAccount;

    @Column(name = "is_payment")
    private Boolean isPayment;

    @Column(name = "student_card_no")
    private String studentCardNo;

    @Column(unique = true,nullable = false)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "sender_act_id")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver_act_id")
    private Account receiver;
}
