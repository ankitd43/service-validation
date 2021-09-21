package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.ValidationResponse;

public interface CustomerDetailService {
    
    public ValidationResponse validationEmail(EmailValidationRequest emailValidationRequest);
}
