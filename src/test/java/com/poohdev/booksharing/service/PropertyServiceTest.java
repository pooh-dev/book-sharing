package com.poohdev.booksharing.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class PropertyServiceTest {

    private static final String NO_APPLICATION_NAME = "No Application Name xxx";
    private static final String APPLICATION_NAME = "Book Sharing Application";

    @Autowired
    private PropertyService propertyService;

    @Test
    void shouldReturnDefaultAppName_whenItsNotSpecified() {
        ReflectionTestUtils.setField(propertyService, "applicationName", "");

        assertThat(propertyService.getApplicationName()).isEqualTo(NO_APPLICATION_NAME);
    }

    @Test
    void shouldReturnAppName_whenItsSpecified() {
        ReflectionTestUtils.setField(propertyService, "applicationName", APPLICATION_NAME);

        assertThat(propertyService.getApplicationName()).isEqualTo(APPLICATION_NAME);
    }
}
