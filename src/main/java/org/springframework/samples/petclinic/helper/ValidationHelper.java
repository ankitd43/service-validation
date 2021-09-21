package org.springframework.samples.petclinic.helper;

import org.apache.commons.validator.routines.IBANValidator;
import org.springframework.samples.petclinic.model.*;

import java.util.regex.*;
public class ValidationHelper {

    public static RequestWrapper<?> validateEmil(String inputEmail){
       String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matches = pattern.matcher(inputEmail);
        boolean isMatch = matches.matches();
        RequestWrapper<?> requestWrapper = RequestWrapper.forname(); 
        if(isMatch){
            requestWrapper.setError(isMatch);
        }else {
            requestWrapper.setError(false);
        }
        return requestWrapper;
    }

    public static RequestWrapper<?> validateAccountNo(String inputAccountNo){
       
        IBANValidator ibn = new  IBANValidator();
        boolean isValid =  ibn.isValid(inputAccountNo);
         RequestWrapper<?> requestWrapper = RequestWrapper.forname(); 
         if(isValid){
             requestWrapper.setError(isValid);
         }else {
             requestWrapper.setError(false);
         }
         return requestWrapper;
     }
    
}
