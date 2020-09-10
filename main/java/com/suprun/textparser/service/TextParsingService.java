package com.suprun.textparser.service;

import com.suprun.textparser.entity.TextPart;

public interface TextParsingService {

    TextPart receiveParsedTextFromFile() throws ServiceException;

    TextPart sortSentencesByWordCount(TextPart textPart) throws ServiceException;

    void printWordsSpecifiedLength(TextPart textPart, int wordLength) throws ServiceException;

    TextPart exchangeFirstAndLastWords(TextPart textPart) throws ServiceException;

    TextPart replaceLetterWords(TextPart textPart) throws ServiceException;

    TextPart replaceWordWithSubstring(TextPart textPart, int wordLength, String subString) throws ServiceException;
}
