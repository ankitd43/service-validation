package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.RequestWrapper;

public interface ValidationService {
    
    public RequestWrapper<?> validateEmail(EmailValidationRequest emailValidationRequest);
}
