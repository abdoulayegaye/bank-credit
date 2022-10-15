package com.bank.credit.bankcredit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    Long id;
    @NotNull(message = "Firstname is not null")
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String address;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;
}