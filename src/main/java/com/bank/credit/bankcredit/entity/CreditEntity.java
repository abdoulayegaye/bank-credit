package com.bank.credit.bankcredit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credits")
public class CreditEntity {
    @Id
    private String creditNumber;
    private double amount;
    private int duration;

    @ManyToOne
    private ClientEntity client;
}
