package com.bank.credit.bankcredit.mapping;

import com.bank.credit.bankcredit.domain.ClientDto;
import com.bank.credit.bankcredit.entity.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientDto toClient(Client client);
    Client fromClient(ClientDto clientDto);
}
