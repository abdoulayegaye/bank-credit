package com.bank.credit.bankcredit.service;

import com.bank.credit.bankcredit.domain.Client;
import com.bank.credit.bankcredit.exception.EntityNotFoundException;
import com.bank.credit.bankcredit.exception.RequestException;
import com.bank.credit.bankcredit.mapping.ClientMapper;
import com.bank.credit.bankcredit.repository.ClientRepository;
import com.bank.credit.bankcredit.repository.CreditRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@AllArgsConstructor
public class ClientService {

    ClientRepository clientRepository;
    CreditRepository creditRepository;
    ClientMapper clientMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public Page<Client> getClients(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toClient);
    }

    @Transactional(readOnly = true)
    public Client getClient(Long id) {
        return clientMapper.toClient(clientRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public Client createClient(Client client) {
        creditRepository.findByCreditNumberIgnoreCase(client.getCredit().getCreditNumber()).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("client.notfound",
                        new Object[]{client.getCredit().getCreditNumber()},
                        Locale.getDefault())));
        client.setId(null);
        return clientMapper.toClient(clientRepository.save(clientMapper.fromClient(client)));
    }

    @Transactional
    public Client updateClient(Long id, Client client){
        return clientRepository.findById(id)
                .map(entity -> {
                    creditRepository.findByCreditNumberIgnoreCase(client.getCredit().getCreditNumber()).orElseThrow(() ->
                            new EntityNotFoundException(messageSource.getMessage("client.notfound",
                                    new Object[]{client.getCredit().getCreditNumber()},
                                    Locale.getDefault())));
                    client.setId(id);
                    return clientMapper.toClient(clientRepository.save(clientMapper.fromClient(client)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("client.notfound",
                        new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("person.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
