package org.springframework.samples.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="account_number")
    private String accountNumber;

    private String name;

    @Column(name ="account_number")
    private String doorNumber;

    @Column(name ="address_line1")
    private String addressLine1;

    @Column(name ="address_line2")
    private String addressLine2;

    private String state;

    private String country;

    @Column(name ="zip_code")
    private int zipCode;
}
