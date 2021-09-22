package org.springframework.samples.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_detail")
public class CustomerDetail {

    @Id
    private Long id;

    @MapsId
    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="transaction_reference")
    private BankStatementDetail bankStatementDetail ;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="phone_number")
    private Long phoneNumber;

    @Column(name="email_id")
    private String emailId;

}
