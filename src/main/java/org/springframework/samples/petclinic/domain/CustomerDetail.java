package org.springframework.samples.petclinic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetail {

    private String accountNumber;
    private Long phoneNumber;
    private Long transactionNumber;
    private String emailId;

    
}
