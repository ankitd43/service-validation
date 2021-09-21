package org.springframework.samples.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestWrapper<T> {
    private boolean error = false;
    private boolean success = true;
    private String message;
    private T t;
    private Map<String, String> map = new HashMap<>();

    public static RequestWrapper<?> forname(){
        return new RequestWrapper<>();
    }
}
