package com.bank.credit.bankcredit.domain;

import com.bank.credit.bankcredit.entity.CreditEntity;
import com.bank.credit.bankcredit.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    Long id;
    @NotNull(message = "Firstname is not null")
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String address;
    @NotNull
    private CreditEntity credit;
}
