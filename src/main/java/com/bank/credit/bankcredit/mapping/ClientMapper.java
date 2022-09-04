package com.bank.credit.bankcredit.mapping;

import com.bank.credit.bankcredit.domain.Client;
import com.bank.credit.bankcredit.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    Client toClient(ClientEntity clientEntity);
    ClientEntity fromClient(Client client);
}
