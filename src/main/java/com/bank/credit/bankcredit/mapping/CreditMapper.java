package com.bank.credit.bankcredit.mapping;

import com.bank.credit.bankcredit.domain.ClientDto;
import com.bank.credit.bankcredit.domain.CreditDto;
import com.bank.credit.bankcredit.entity.Client;
import com.bank.credit.bankcredit.entity.Credit;
import org.mapstruct.Mapper;

@Mapper
public interface CreditMapper {
    CreditDto toCredit(Credit credit);
    Credit fromCredit(CreditDto creditDto);
}
