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
            requestWrapper.setError(true);
            requestWrapper.setMessage("INCORRECT_EMAIL_ID");
        }
        return requestWrapper;
    }

    public static RequestWrapper<?> validateAccountNo(String inputAccountNo){
       
        IBANValidator ibn = new  IBANValidator();
        boolean isValid =  ibn.isValid(inputAccountNo);
         RequestWrapper<?> requestWrapper = RequestWrapper.forname(); 
         if(isValid){
             requestWrapper.setSuccess(isValid);
         }else {
             requestWrapper.setError(true);
             requestWrapper.setMessage("INCORRECT_Account_No");
         }
         return requestWrapper;
     }

     public static RequestWrapper<?> validatePhoneNo(Long inputPhoneNO){
        String regex = "(country-code)[0-9]{8}";
        RequestWrapper<?> requestWrapper = RequestWrapper.forname(); 
        if(Pattern.matches(regex , inputPhoneNO.toString())) {
            requestWrapper.setSuccess(true);
        }else {
            requestWrapper.setError(true);
            requestWrapper.setMessage("INCORRECT_PHONE_NO");
        }
        return requestWrapper;
     }

     public static RequestWrapper<?> validateDoorNo(String inputDoorNo){
        String regex = "^[a-zA-Z0-9/-]+[a-zA-Z0-9.-]+$";
        RequestWrapper<?> requestWrapper = RequestWrapper.forname(); 
        if(Pattern.matches(regex , inputDoorNo)) {
            requestWrapper.setSuccess(true);
        }else {
            requestWrapper.setError(true);
            requestWrapper.setMessage("INCORRECT_DOOR_No");
        }
        return requestWrapper;
     }

     public static RequestWrapper<?> validateZipCode(int inputZipCode){
        String regex = "^\\d{1,5}$";
        RequestWrapper<?> requestWrapper = RequestWrapper.forname(); 
        if(Pattern.matches(regex , inputZipCode+"")) {
            requestWrapper.setSuccess(true);
        }else {
            requestWrapper.setError(true);
            requestWrapper.setMessage("INCORRECT_ZIPCODE");
        }
        return requestWrapper;
     }
    
}
