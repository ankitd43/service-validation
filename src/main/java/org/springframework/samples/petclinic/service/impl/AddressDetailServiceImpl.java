package org.springframework.samples.petclinic.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.AddressDetail;
import org.springframework.samples.petclinic.model.AddressValidationRequest;
import org.springframework.samples.petclinic.model.RequestWrapper;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.repository.AddressDetailRepository;
import org.springframework.samples.petclinic.service.AddressDetailService;
import org.springframework.samples.petclinic.service.ValidationService;

public class AddressDetailServiceImpl implements AddressDetailService {
    
    @Autowired
    private ValidationService validationService;

    @Autowired
    private AddressDetailRepository addressDetailRepository;
    
    @Override
    public ValidationResponse validationAddress(AddressValidationRequest addressValidationRequest){
        ValidationResponse validationResponse = new ValidationResponse();
        RequestWrapper<?> requestWrapper =  validationService.validateAddress(addressValidationRequest);
        if(requestWrapper.isSuccess()){
            String accountNumber = addressValidationRequest.getAccountNumber();
            
            AddressDetail addressDetail = addressDetailRepository.findByAccountNumber(accountNumber);
            if(addressDetail == null){
                addressDetail = new AddressDetail();
            }else{
                BeanUtils.copyProperties(addressValidationRequest, addressDetail, "accountNumber");
                addressDetailRepository.save(addressDetail); 
            }
        }
        if(requestWrapper.isError())
            requestWrapper.getMap().put("accountNumber","account_number_of_error_record");
        validationResponse.setResult(requestWrapper.getMessage());
        validationResponse.setErrorRecords(requestWrapper.getMap());
        return validationResponse;
    }
}
