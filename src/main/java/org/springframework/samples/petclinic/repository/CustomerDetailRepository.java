package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.domain.CustomerDetail;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long>{

    CustomerDetail findByEmailIdOrAccountNumber(String emailId , String accountNo );

    CustomerDetail findByPhoneNumberOrAccountNumber(String phoneNo , String accountNo );

    CustomerDetail findByAccountNumber(String emailId , String accountNo );

}
