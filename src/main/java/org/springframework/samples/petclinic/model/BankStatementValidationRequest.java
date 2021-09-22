package org.springframework.samples.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankStatementValidationRequest {
    
    private Long transactionReference;
    private String accountNumber;
    private String startBalance;
    private String endBalance;
    private String mutation;
    private String description;

}
