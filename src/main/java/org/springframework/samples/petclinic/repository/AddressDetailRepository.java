package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.domain.AddressDetail;

public interface AddressDetailRepository extends JpaRepository<AddressDetail, Long>{

    AddressDetail findByAccountNumber(String accountNo);
    
}
