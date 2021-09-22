package org.springframework.samples.petclinic.service.impl;

import org.springframework.samples.petclinic.model.BankStatementValidationRequest;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.service.BankStatementDetailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.domain.BankStatementDetail;
import org.springframework.samples.petclinic.helper.ValidationHelper;
import org.springframework.samples.petclinic.model.RequestWrapper;
import org.springframework.samples.petclinic.model.ValidationResponse;
import org.springframework.samples.petclinic.repository.BankStatementDetailRepository;


@Service
public class BankStatementDetailServiceImpl implements BankStatementDetailService{

    @Autowired
    private BankStatementDetailRepository bankStatementDetailRepository;
    
    @Override
    public ValidationResponse validationBankStatement(BankStatementValidationRequest bankStatementValidationRequest){
        ValidationResponse validationResponse = new ValidationResponse();
        RequestWrapper<?> requestWrapper =  ValidationHelper.validateAccountNo(bankStatementValidationRequest.getAccountNumber());
        if(requestWrapper.isSuccess()){
            String accountNumber = bankStatementValidationRequest.getAccountNumber();
            
            BankStatementDetail bankStatementDetail = bankStatementDetailRepository.findByAccountNumber(accountNumber);
            if(bankStatementDetail == null){
                bankStatementDetail = new BankStatementDetail();
            }else{
                BeanUtils.copyProperties(bankStatementValidationRequest, bankStatementDetail, "accountNumber");
                bankStatementDetailRepository.save(bankStatementDetail); 
            }
        }
        if(requestWrapper.isError())
            requestWrapper.getMap().put("accountNumber","account_number_of_error_record");
        validationResponse.setResult(requestWrapper.getMessage());
        validationResponse.setErrorRecords(requestWrapper.getMap());
        return validationResponse;
    }
}
