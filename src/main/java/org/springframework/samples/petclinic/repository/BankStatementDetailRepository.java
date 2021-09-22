package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.domain.BankStatementDetail;

public interface BankStatementDetailRepository extends JpaRepository<BankStatementDetail, Long> {

    BankStatementDetail findByAccountNumber(String accountNumber);
    
}
