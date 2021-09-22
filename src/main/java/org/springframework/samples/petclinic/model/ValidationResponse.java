package org.springframework.samples.petclinic.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResponse {
   
    private String result;
    private Map<String,String> errorRecords = new HashMap<>();


}
