package com.example.patrimoineapi.patrimoine_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PatrimoineApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateOrUpdatePatrimoine() throws Exception {
        String json = "{\"possesseur\":\"John Doe\", \"derniereModification\":\"2023-09-23T10:15:30\"}";

        mockMvc.perform(put("/patrimoines/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPatrimoine() throws Exception {
        mockMvc.perform(get("/patrimoines/1"))
                .andExpect(status().isOk());
    }
}
