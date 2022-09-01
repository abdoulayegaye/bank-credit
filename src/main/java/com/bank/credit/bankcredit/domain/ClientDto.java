package com.bank.credit.bankcredit.domain;

import com.bank.credit.bankcredit.entity.Credit;
import com.bank.credit.bankcredit.entity.Gender;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClientDto {
    @NotNull
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
}
