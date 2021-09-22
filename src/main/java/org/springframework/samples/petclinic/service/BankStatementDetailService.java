package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.BankStatementValidationRequest;
import org.springframework.samples.petclinic.model.ValidationResponse;

public interface BankStatementDetailService {
    
    public ValidationResponse validationBankStatement(BankStatementValidationRequest bankStatementValidationRequest);
}
