package com.suprun.textparser;

import com.suprun.textparser.entity.TextPart;
import com.suprun.textparser.service.ServiceException;
import com.suprun.textparser.service.ServiceFactory;
import com.suprun.textparser.service.TextParsingService;

public class Main {

    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextParsingService textParsingService = serviceFactory.getTextParsingService();
        TextPart textPart;
        try {
            textPart = textParsingService.receiveParsedTextFromFile();
            System.out.println(textPart.toString());
            textParsingService.printWordsSpecifiedLength(textPart, 2);
            textPart = textParsingService.exchangeFirstAndLastWords(textPart);
            System.out.println(textPart.toString());
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
