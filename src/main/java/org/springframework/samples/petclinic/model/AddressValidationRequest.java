package org.springframework.samples.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressValidationRequest {
    
    private String accountNumber;
    private String name;
    private String doorNumber;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private int zipCode;


}
