package com.poohdev.booksharing.service.impl;

import com.poohdev.booksharing.service.PropertyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    private static final String NO_APPLICATION_NAME = "No Application Name";

    @Value("${book.sharing.app.name}")
    private String applicationName;

    public String getApplicationName() {
        return StringUtils.isBlank(applicationName)
                ? NO_APPLICATION_NAME
                : applicationName;
    }
}
