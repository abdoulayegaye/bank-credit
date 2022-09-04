package com.bank.credit.bankcredit.repository;

import com.bank.credit.bankcredit.entity.CreditEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditRepository extends CrudRepository<CreditEntity, String> {
    Optional<CreditEntity> findByCreditNumberIgnoreCase(String creditNumber);
}
