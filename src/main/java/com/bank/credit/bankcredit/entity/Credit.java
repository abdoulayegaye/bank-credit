package com.bank.credit.bankcredit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
    @Id
    private String creditNumber;
    private double amount;
    private int duration;

    @ManyToOne
    private Client client;
}
