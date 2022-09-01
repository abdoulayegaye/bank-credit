package com.bank.credit.bankcredit.domain;

import com.bank.credit.bankcredit.entity.Client;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class CreditDto {
    @NotNull
    private String creditNumber;
    @NotNull
    private double amount;
    @NotNull
    private int duration;

}
