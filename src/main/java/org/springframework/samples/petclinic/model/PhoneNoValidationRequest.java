package org.springframework.samples.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNoValidationRequest {
    
    private String accountNumber;
    private Long phoneNumber;
    private Long transactionReference;
    
}
