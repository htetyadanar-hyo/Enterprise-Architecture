package accounts.controller;


import accounts.service.AccountResponse;
import accounts.service.AccountService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccountByAccountNumber() throws Exception {
        AccountResponse accountResponse = new AccountResponse("1111", 12.32, "frank");
        Mockito.when(accountService.getAccount("1111")).thenReturn(accountResponse);

        mockMvc.perform(get("/account/1111"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("1111"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(12.32))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("frank"));
    }

    @Test
    public void testCreateAccountB() throws Exception {
        String accountJson = asJsonString(new AccountResponse("1111", 12.21, "frank"));
        mockMvc.perform(MockMvcRequestBuilders.post("/createaccount/1111/12.21/frank")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJson))
                        .andExpect(status().isOk());

        verify(accountService, times(1)).createAccount("1111", 12.21, "frank");
    }


    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
