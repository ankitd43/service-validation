package org.springframework.samples.petclinic.service.impl;

import org.springframework.samples.petclinic.helper.ValidationHelper;
import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.RequestWrapper;
import org.springframework.samples.petclinic.service.*;
import org.springframework.util.Assert;
public class ValidationServiceImpl implements ValidationService {
    
    @Override
    public RequestWrapper<?> validateEmail(EmailValidationRequest emailValidationRequest){
        Assert.isNull(emailValidationRequest.getEmailId(), "Email Id should not be null or empty");
        Assert.isNull(emailValidationRequest.getAccountNumber(), "Account No should not be null or empty");
        Assert.isNull(emailValidationRequest.getTransactionNumber(), "Transaction No should not be null or empty");
        RequestWrapper<?> requestWrapper = ValidationHelper.validateEmil(emailValidationRequest.getEmailId());
        if(requestWrapper.isError()){
            requestWrapper.setMessage("INCORRECT_EMAIL_ID");
        } 
        requestWrapper = ValidationHelper.validateAccountNo(emailValidationRequest.getAccountNumber());
        if(requestWrapper.isError()){
            requestWrapper.setMessage("INCORRECT_Account_No");
        }
        return requestWrapper;
    }
}
