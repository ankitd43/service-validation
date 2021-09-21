package org.springframework.samples.petclinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.CustomerDetail;
import org.springframework.samples.petclinic.model.EmailValidationRequest;
import org.springframework.samples.petclinic.model.PhoneNoValidationRequest;
import org.springframework.samples.petclinic.model.RequestWrapper;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.repository.CustomerDetailRepository;
import org.springframework.samples.petclinic.service.CustomerDetailService;
import org.springframework.samples.petclinic.service.ValidationService;

public class CustomerDetailServiceImpl implements CustomerDetailService{
    
    @Autowired
    private ValidationService validationService;

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @Override
    public ValidationResponse validationEmail(EmailValidationRequest emailValidationRequest ){
        ValidationResponse validationResponse = new ValidationResponse();
        RequestWrapper<?> requestWrapper =  validationService.validateEmail(emailValidationRequest);
        if(requestWrapper.isError()){
            String accountNumber = emailValidationRequest.getAccountNumber();
            String emailId = emailValidationRequest.getEmailId();
            CustomerDetail customerDetail = customerDetailRepository.findByEmailIdOrAccountNumber(emailId, accountNumber);
            if(customerDetail == null){
                customerDetail = new CustomerDetail();
            }else{
                if(emailId.equals(customerDetail.getEmailId())){
                    if(!accountNumber.equals(customerDetail.getAccountNumber())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_ACCOUNT_NO");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_EMAIL_ID");
                }

                if(accountNumber.equals(customerDetail.getAccountNumber())){
                    if(!emailId.equals(customerDetail.getEmailId())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_EMAIL_ID");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_ACCOUNT_NO");
                }
            } 
        }else{
            requestWrapper.setMessage("SUCCESS");
        }
        validationResponse.setResult(requestWrapper.getMessage());
        return validationResponse;
    }

    @Override
    public ValidationResponse validationPhoneNO(PhoneNoValidationRequest phoneNoValidationRequest ){
        ValidationResponse validationResponse = new ValidationResponse();
        RequestWrapper<?> requestWrapper =  validationService.validateEmail(phoneNoValidationRequest);
        if(requestWrapper.isError()){
            String accountNumber = phoneNoValidationRequest.getAccountNumber();
            Long emailId = phoneNoValidationRequest.getPhoneNumber();
            CustomerDetail customerDetail = customerDetailRepository.findByEmailIdOrAccountNumber(emailId, accountNumber);
            if(customerDetail == null){
                customerDetail = new CustomerDetail();
            }else{
                if(emailId.equals(customerDetail.getEmailId())){
                    if(!accountNumber.equals(customerDetail.getAccountNumber())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_ACCOUNT_NO");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_EMAIL_ID");
                }

                if(accountNumber.equals(customerDetail.getAccountNumber())){
                    if(!emailId.equals(customerDetail.getEmailId())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_EMAIL_ID");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_ACCOUNT_NO");
                }
            } 
        }else{
            requestWrapper.setMessage("SUCCESS");
        }
        validationResponse.setResult(requestWrapper.getMessage());
        return validationResponse;
    }
}
