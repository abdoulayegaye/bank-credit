package com.bank.credit.bankcredit.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit implements Serializable {
    @NotNull(message = "CreditEntity is not null")
    private String creditNumber;
    @NotNull
    private double amount;
    @NotNull
    private int duration;

}
