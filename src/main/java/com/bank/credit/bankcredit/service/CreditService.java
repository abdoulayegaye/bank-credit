package com.bank.credit.bankcredit.service;

import com.bank.credit.bankcredit.domain.Credit;
import com.bank.credit.bankcredit.exception.EntityNotFoundException;
import com.bank.credit.bankcredit.exception.RequestException;
import com.bank.credit.bankcredit.mapping.CreditMapper;
import com.bank.credit.bankcredit.repository.ClientRepository;
import com.bank.credit.bankcredit.repository.CreditRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CreditService {

    CreditRepository creditRepository;
    ClientRepository clientRepository;
    CreditMapper creditMapper;
    MessageSource messageSource;

    @Transactional(readOnly = true)
    public List<Credit> getCredits() {
        return StreamSupport.stream(creditRepository.findAll().spliterator(), false)
                .map(creditMapper::toCredit)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Credit getCredit(String creditNumber) {
        return creditMapper.toCredit(creditRepository.findByCreditNumberIgnoreCase(creditNumber).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("credit.notfound", new Object[]{creditNumber},
                        Locale.getDefault()))));
    }

    @Transactional
    public Credit createCredit(Credit credit) {
        clientRepository.findById(credit.getClient().getId()).orElseThrow(() ->
                new EntityNotFoundException(
                        messageSource.getMessage("client.notfound",
                                new Object[]{credit.getClient().getId()},
                                Locale.getDefault())
                )
        );
        creditRepository.findByCreditNumberIgnoreCase(credit.getCreditNumber())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("credit.exists", new Object[]{credit.getCreditNumber()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return creditMapper.toCredit(creditRepository.save(creditMapper.fromCredit(credit)));
    }

    @Transactional
    public Credit updateCredit(String creditNumber, Credit credit) {
        return creditRepository.findByCreditNumberIgnoreCase(creditNumber)
                .map(entity -> {
                    credit.setCreditNumber(creditNumber);
                    return creditMapper.toCredit(
                            creditRepository.save(creditMapper.fromCredit(credit)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("credit.notfound", new Object[]{creditNumber},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteCredit(String creditNumber) {
        try {
            creditRepository.deleteById(creditNumber);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("credit.errordeletion", new Object[]{creditNumber},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
