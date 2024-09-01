package com.example.project.uber.uberApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    private Double balance;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<WalletTransaction> walletTransactions;

}
