package com.suprun.textparser.service;

import com.suprun.textparser.service.impl.TextParsingServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final TextParsingService textParsingService = new TextParsingServiceImpl();

    private ServiceFactory() {
    }

    public TextParsingService getTextParsingService() {

        return textParsingService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
