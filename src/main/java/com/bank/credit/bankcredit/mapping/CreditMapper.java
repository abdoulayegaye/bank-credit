package com.bank.credit.bankcredit.mapping;

import com.bank.credit.bankcredit.domain.Credit;
import com.bank.credit.bankcredit.entity.CreditEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CreditMapper {
    Credit toCredit(CreditEntity creditEntity);
    CreditEntity fromCredit(Credit credit);
}
