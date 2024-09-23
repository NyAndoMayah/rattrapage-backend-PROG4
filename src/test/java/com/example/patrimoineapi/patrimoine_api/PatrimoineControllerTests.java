package com.example.patrimoineapi.patrimoine_api;

import com.example.patrimoineapi.patrimoine_api.model.Patrimoine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PatrimoineControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private Patrimoine patrimoine;

    @BeforeEach
    public void setUp() {
        patrimoine = new Patrimoine();
        patrimoine.setPossesseur("John Doe");
        patrimoine.setDerniereModification(LocalDateTime.now());
    }

    @Test
    public void testCreateOrUpdatePatrimoine() throws Exception {
        String json = "{\"possesseur\":\"John Doe\", \"derniereModification\":\"2023-09-23T10:15:30\"}";

        mockMvc.perform(put("/patrimoines/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        String updatedJson = "{\"possesseur\":\"Jane Doe\", \"derniereModification\":\"2023-09-24T10:15:30\"}";
        mockMvc.perform(put("/patrimoines/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPatrimoine() throws Exception {
        String json = "{\"possesseur\":\"John Doe\", \"derniereModification\":\"2023-09-23T10:15:30\"}";
        mockMvc.perform(put("/patrimoines/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        mockMvc.perform(get("/patrimoines/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    @Test
    public void testGetPatrimoineNotFound() throws Exception {
        mockMvc.perform(get("/patrimoines/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateOrUpdateInvalidPatrimoine() throws Exception {
        String invalidJson = "{\"possesseur\":\"\", \"derniereModification\":\"\"}";

        mockMvc.perform(put("/patrimoines/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}