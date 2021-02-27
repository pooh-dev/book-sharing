package com.poohdev.booksharing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.poohdev.booksharing.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PropertyController.class)
public class PropertyControllerTest {
    private static final String APP_NAME_URL = "/property/app-name";
    private static final String APPLICATION_NAME = "Application Name";

    @Autowired
    private MockMvc propertyController;
    @MockBean
    private PropertyService propertyService;

    @Test
    void shouldReturnAppName() throws Exception {
        when(propertyService.getApplicationName()).thenReturn(APPLICATION_NAME);

        propertyController
                .perform(get(APP_NAME_URL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(APPLICATION_NAME));
    }
}
