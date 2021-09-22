package org.springframework.samples.petclinic.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.AddressDetail;
import org.springframework.samples.petclinic.model.AddressValidationRequest;
import org.springframework.samples.petclinic.model.RequestWrapper;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.repository.AddressDetailRepository;
import org.springframework.samples.petclinic.service.AddressDetailService;
import org.springframework.samples.petclinic.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class AddressDetailServiceImpl implements AddressDetailService {
    
    @Autowired
    private ValidationService validationService;

    @Autowired
    private AddressDetailRepository addressDetailRepository;
    
    @Override
    public ValidationResponse validationAddress(List<AddressValidationRequest> addressValidationRequestList){
        ValidationResponse validationResponse = new ValidationResponse();
        Set<String> items1 = new HashSet<>();
        Set<AddressValidationRequest> items2 = new HashSet<>();
        items2 = addressValidationRequestList.stream()
        .filter(n -> !items1.add(n.getAccountNumber()))
        .collect(Collectors.toSet());
        if(items2.size() > 0 ){
            validationResponse.setResult("DUPLICATE_ACCOUNT");
            Map<String,String> errorRecords = new HashMap<>();
            items2.stream().forEach(q-> errorRecords.put(q.getDoorNumber(), q.getAccountNumber()+" account_number_of_error_record"));
            validationResponse.setErrorRecords(errorRecords); 
            return validationResponse;
        }
        for (AddressValidationRequest addressValidationRequest : addressValidationRequestList) {
            RequestWrapper<?> requestWrapper =  validationService.validateAddress(addressValidationRequest);
            if(requestWrapper.isSuccess()){
                String accountNumber = addressValidationRequest.getAccountNumber();
                
                AddressDetail addressDetail = addressDetailRepository.findByAccountNumber(accountNumber);
                if(addressDetail == null){
                    addressDetail = new AddressDetail();
                }
                BeanUtils.copyProperties(addressValidationRequest, addressDetail, "accountNumber");
                addressDetail.setAccountNumber(addressValidationRequest.getAccountNumber());
                addressDetailRepository.save(addressDetail); 
            }
            if(requestWrapper.isError())
                requestWrapper.getMap().put("accountNumber","account_number_of_error_record");
                validationResponse.setResult(requestWrapper.getMessage());
                validationResponse.setErrorRecords(requestWrapper.getMap());    
        }
        
        return validationResponse;
    }
}
