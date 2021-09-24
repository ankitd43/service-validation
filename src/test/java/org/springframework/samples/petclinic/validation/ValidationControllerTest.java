
package org.springframework.samples.petclinic.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.samples.petclinic.controller.ValidationController;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@WebMvcTest(ValidationController.class)

@AutoConfigureMockMvc
@WebAppConfiguration
@SpringBootTest
public class ValidationControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTriggerException() throws Exception {
        
                mockMvc.perform(post("/validation/validateEmail")
                .param("accountNumber", "12454343")
                .param("emailId", "ak.g1104@gmail.com")
                .param("transactionReference", "1")   
            ).andExpect(status().isOk());       
    }
}
