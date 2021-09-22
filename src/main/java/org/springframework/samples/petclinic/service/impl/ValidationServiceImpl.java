package org.springframework.samples.petclinic.service.impl;

import org.springframework.samples.petclinic.helper.ValidationHelper;
import org.springframework.samples.petclinic.model.AddressValidationRequest;
import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.PhoneNoValidationRequest;
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
        
        if(requestWrapper.isSuccess()){
            requestWrapper = ValidationHelper.validateAccountNo(emailValidationRequest.getAccountNumber());
        }
        
        return requestWrapper;
    }

    @Override
    public RequestWrapper<?> validatePhoneNo(PhoneNoValidationRequest phoneNoValidationRequest){
        Assert.isNull(phoneNoValidationRequest.getPhoneNumber(), "Phone No should not be null or empty");
        Assert.isNull(phoneNoValidationRequest.getAccountNumber(), "Account No should not be null or empty");
        Assert.isNull(phoneNoValidationRequest.getTransactionNumber(), "Transaction No should not be null or empty");
        RequestWrapper<?> requestWrapper = ValidationHelper.validatePhoneNo(phoneNoValidationRequest.getPhoneNumber());

        if(requestWrapper.isSuccess()){
            requestWrapper = ValidationHelper.validateAccountNo(phoneNoValidationRequest.getAccountNumber());
        }
        return requestWrapper;
    }

    @Override
    public RequestWrapper<?> validateAddress(AddressValidationRequest addressValidationRequest){
        Assert.isNull(addressValidationRequest.getName(), "Name should not be null or empty");
        Assert.isNull(addressValidationRequest.getAccountNumber(), "Account No should not be null or empty");
        Assert.isNull(addressValidationRequest.getCountry(), "Country should not be null or empty");
        Assert.isNull(addressValidationRequest.getState(), "State should not be null or empty");
        Assert.isNull(addressValidationRequest.getZipCode(), "Zipcode should not be null or empty");
        Assert.isNull(addressValidationRequest.getDoorNumber(), "Door Number should not be null or empty");

        RequestWrapper<?> requestWrapper = ValidationHelper.validateAccountNo(addressValidationRequest.getAccountNumber());
        if(requestWrapper.isSuccess()){
            requestWrapper = ValidationHelper.validateDoorNo(addressValidationRequest.getDoorNumber());
            if(requestWrapper.isSuccess()){
                requestWrapper = ValidationHelper.validateZipCode(addressValidationRequest.getZipCode());
            } 
        }
        return requestWrapper;
    }
}
