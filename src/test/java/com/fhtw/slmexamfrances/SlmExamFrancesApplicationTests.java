package com.fhtw.slmexamfrances;

import com.fhtw.slmexamfrances.model.ApiModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SlmExamFrancesApplicationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void contextLoads() {
    }
    @BeforeEach
    void clear(){

    }

    @Test
    void unitTestTaxCalculartor() {
        ApiModel taxObject = new ApiModel();
        double price = 4.5;
        double percent = 10;
        double expected = price+price*percent/100;
        taxObject.setPrice(price);
        taxObject.setTaxPercent(percent);
        assertEquals(expected, taxObject.calculateTax());
    }


    @Test
    public void setTest() throws Exception {
        String testMessage = "newMessage";

        RequestBuilder setRequest = MockMvcRequestBuilders.get("/api/tax?netprice=12.22&taxpercent=20");
        MvcResult result = mockMvc.perform(setRequest).andExpect(status().isOk()).andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"))).andReturn();;;


        assertEquals("14,664000", result);

    }


}
