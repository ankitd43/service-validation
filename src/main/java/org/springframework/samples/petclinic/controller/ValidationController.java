package org.springframework.samples.petclinic.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.model.AddressValidationRequest;
import org.springframework.samples.petclinic.model.BankStatementValidationRequest;
import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.service.AddressDetailService;
import org.springframework.samples.petclinic.service.BankStatementDetailService;
import org.springframework.samples.petclinic.service.CustomerDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ValidationController {
    
    @Autowired
    private CustomerDetailService customerDetailService ;

    @Autowired
    private AddressDetailService addressDetailService;

    @Autowired
    private BankStatementDetailService bankStatementDetailService;

    @GetMapping(value = "/ping", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String ping(){
        return "Ping Success";
    }

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

     @PostMapping(value="/validateAddress" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse validateAddres(@RequestBody List<AddressValidationRequest> addressValidationRequestList ) {
        
        ValidationResponse validationResponse = addressDetailService.validationAddress(addressValidationRequestList);
        return validationResponse;
    }

    @PostMapping(value="/validateBankStatement" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ValidationResponse validateBankStatement(@RequestBody BankStatementValidationRequest bankStatementValidationRequest ) {
        
        ValidationResponse validationResponse = bankStatementDetailService.validationBankStatement(bankStatementValidationRequest);
        return validationResponse;
    }
}
