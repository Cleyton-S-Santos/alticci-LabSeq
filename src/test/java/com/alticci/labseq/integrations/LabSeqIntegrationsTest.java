package com.alticci.labseq.integrations;

import com.alticci.labseq.service.LabseqService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LabSeqIntegrationsTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    LabseqService service;

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,1", "3,1", "4,2", "5,2", "6,3", "7,4", "8,5", "9,7", "10,9"})
    void shouldReturnTheEquivalentValue(long index, long value) throws Exception {

        mockMvc
                .perform(get("/labseq/" + index))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Negative index input")
    void findAlticciIndexShouldReturnABadRequestWhenInputIndexIsNotPositive() throws Exception {

        mockMvc
                .perform(get("/labseq/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Value not accepted, please enter a positive number or a smaller one!"));
    }
}
