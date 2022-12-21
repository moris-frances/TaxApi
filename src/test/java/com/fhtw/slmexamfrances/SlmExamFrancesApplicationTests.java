package com.fhtw.slmexamfrances;

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
    String expected = "OK DOC";
    @Test
    public void getTest() throws Exception {
        RequestBuilder getRequest = MockMvcRequestBuilders.get("/api/get");
        String expected = "Default";
        MvcResult result = mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"))).andReturn();
        String actual = result.getResponse().getContentAsString();

        assertEquals(expected, actual);
    }
    @Test
    public void setTest() throws Exception {
        String testMessage = "newMessage";
        RequestBuilder setRequest = MockMvcRequestBuilders.get("/api/set?m=" + testMessage);
        mockMvc.perform(setRequest).andExpect(status().isOk());;

        RequestBuilder getRequest = MockMvcRequestBuilders.get("/api/get");
        MvcResult result = mockMvc.perform(getRequest)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8"))).andReturn();
        String actual = result.getResponse().getContentAsString();
        assertEquals(testMessage, actual);

    }
    @Test
    public void postTest() throws Exception {

    }

}
