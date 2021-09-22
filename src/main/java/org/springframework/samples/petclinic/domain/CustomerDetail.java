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
public class CustomerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="phone_number")
    private Long phoneNumber;

    @Column(name="transaction_reference")
    private Long transactionReference;

    @Column(name="email_id")
    private String emailId;

}
