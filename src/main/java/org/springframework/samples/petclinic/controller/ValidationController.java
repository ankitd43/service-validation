package org.springframework.samples.petclinic.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.service.CustomerDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ValidationController {
    
    @Autowired
    private CustomerDetailService customerDetailService ;
    @PostMapping(value="/validateEmail" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse validateEmail(@RequestBody EmailValidationRequest emailValidationRequest) {
        
        ValidationResponse validationResponse = customerDetailService.validationEmail(emailValidationRequest);
        return validationResponse;
    }
    
    @PostMapping(value="/validatePhoneNo" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse validatePhoneNo(@RequestBody EmailValidationRequest emailValidationRequest) {
        
        ValidationResponse validationResponse = customerDetailService.validationEmail(emailValidationRequest);
        return validationResponse;
    }
}
