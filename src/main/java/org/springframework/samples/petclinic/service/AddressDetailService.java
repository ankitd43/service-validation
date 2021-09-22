package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.AddressValidationRequest;
import org.springframework.samples.petclinic.model.ValidationResponse;

public interface AddressDetailService {
 
    public ValidationResponse validationAddress(List<AddressValidationRequest> addressValidationRequestList);
}
