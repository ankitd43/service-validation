package org.springframework.samples.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailValidationRequest {
    
    private String accountNumber;
    private Long transactionNumber;
    private String emailId;
}
