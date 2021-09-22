package org.springframework.samples.petclinic.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.CustomerDetail;
import org.springframework.samples.petclinic.model.AddressValidationRequest;
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
                    if(accountNumber.equals(customerDetail.getAccountNumber())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_ACCOUNT_NO");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_EMAIL_ID");
                }

                if(accountNumber.equals(customerDetail.getAccountNumber())){
                    if(emailId.equals(customerDetail.getEmailId())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_EMAIL_ID");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_ACCOUNT_NO");
                }
            } if(requestWrapper.isSuccess()){
                BeanUtils.copyProperties(emailValidationRequest, customerDetail);
                customerDetailRepository.save(customerDetail);
            } 
        }
        if(requestWrapper.isError())
            requestWrapper.getMap().put("accountNumber","account_number_of_error_record");

        validationResponse.setResult(requestWrapper.getMessage());
        validationResponse.setErrorRecords(requestWrapper.getMap());
        validationResponse.setResult(requestWrapper.getMessage());
        return validationResponse;
    }

    @Override
    public ValidationResponse validationPhoneNo(PhoneNoValidationRequest phoneNoValidationRequest ){
        ValidationResponse validationResponse = new ValidationResponse();
        RequestWrapper<?> requestWrapper =  validationService.validatePhoneNo(phoneNoValidationRequest);
        if(requestWrapper.isSuccess()){
            String accountNumber = phoneNoValidationRequest.getAccountNumber();
            Long phoneNo = phoneNoValidationRequest.getPhoneNumber();
            CustomerDetail customerDetail = customerDetailRepository.findByPhoneNumberOrAccountNumber(phoneNo, accountNumber);
            if(customerDetail == null){
                customerDetail = new CustomerDetail();
            }else{
                if(phoneNo.equals(customerDetail.getPhoneNumber())){
                    if(accountNumber.equals(customerDetail.getAccountNumber())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_ACCOUNT_NO");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_PHONE_NO");
                }

                if(accountNumber.equals(customerDetail.getAccountNumber())){
                    if(phoneNo.equals(customerDetail.getPhoneNumber())){
                        requestWrapper.setMessage("SUCCESS");
                    }else{
                        requestWrapper.setMessage("DUPLICATE_PHONE_NO");
                    }
                }else{
                    requestWrapper.setMessage("INCORRECT_ACCOUNT_NO");
                }
            }
            if(requestWrapper.isSuccess()){
                BeanUtils.copyProperties(phoneNoValidationRequest, customerDetail);
                customerDetailRepository.save(customerDetail);
            } 
        }
        if(requestWrapper.isError())
            requestWrapper.getMap().put("accountNumber","account_number_of_error_record");
        validationResponse.setResult(requestWrapper.getMessage());
        validationResponse.setErrorRecords(requestWrapper.getMap());
        return validationResponse;
    }

    
}
