package com.bank.credit.bankcredit.repository;

import com.bank.credit.bankcredit.entity.ClientEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {
}
