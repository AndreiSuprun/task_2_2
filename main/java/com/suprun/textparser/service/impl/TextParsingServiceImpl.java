package com.suprun.textparser.service.impl;

import com.suprun.textparser.dao.DaoException;
import com.suprun.textparser.dao.DaoFactory;
import com.suprun.textparser.dao.TextParsingDao;
import com.suprun.textparser.entity.TextPart;
import com.suprun.textparser.entity.Word;
import com.suprun.textparser.service.ServiceException;
import com.suprun.textparser.service.TextParsingService;

import java.util.Comparator;
import java.util.List;

public class TextParsingServiceImpl implements TextParsingService {

    private static final String IGNORE_CASE_SELECTOR = "(?i)";

    @Override
    public TextPart receiveParsedTextFromFile() throws ServiceException {
        DaoFactory factory = DaoFactory.getInstance();
        TextParsingDao textParsingDao = factory.getTextParsingDao();
        TextPart textPart;
        try{
            textPart = textParsingDao.receiveParsedText();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return textPart;
    }

    @Override
    public TextPart sortSentencesByWordCount(TextPart textPart) throws ServiceException {
        if (textPart ==null){
            throw new ServiceException("Invalid parameter");
        }
        Comparator<TextPart> sentenceComparator = Comparator.comparingInt(c -> c.toString().split("\\s+").length);
        for (TextPart paragraph : textPart.getParts()) {
            paragraph.getParts().sort(sentenceComparator);
        }
        return textPart;
    }

    @Override
    public void printWordsSpecifiedLength(TextPart textPart, int wordLength) throws ServiceException {
        if (textPart ==null || wordLength <= 0){
            throw new ServiceException("Invalid parameter");
        }
        for (TextPart paragraph : textPart.getParts()) {
            paragraph.getParts().stream().filter(s -> {
                List<TextPart> list = s.getParts();
                return list.get(list.size() - 1).toString().contains("?");
            }).flatMap(s -> s.getParts().stream()).filter(s -> s.toString().length() == wordLength).distinct().forEach(System.out::println);
        }
    }

    @Override
    public TextPart exchangeFirstAndLastWords(TextPart textPart) throws ServiceException {
        if (textPart ==null){
            throw new ServiceException("Invalid parameter");
        }
        for (TextPart paragraph : textPart.getParts()) {
            for (TextPart sentence : paragraph.getParts()) {
                List<TextPart> list = sentence.getParts();
                if (list.size() > 1) {
                    TextPart firstWord = list.get(0);
                    list.set(0, list.get(list.size() - 2));
                    list.set(list.size() - 2, firstWord);
                }
            }
        }
        return textPart;
    }

    @Override
    public TextPart replaceLetterWords(TextPart textPart) throws ServiceException {
        if (textPart ==null){
            throw new ServiceException("Invalid parameter");
        }
        for (TextPart paragraph : textPart.getParts()) {
            for (TextPart sentence : paragraph.getParts()) {
                for (TextPart word : sentence.getParts()) {
                    if (word.toString().length() > 1) {
                        String letter = String.valueOf(word.toString().charAt(0));
                        String newWord = word.toString().replaceAll(IGNORE_CASE_SELECTOR+letter, "");
                        word.setPart(new Word(letter.concat(newWord)));
                    }
                }
            }
        }
        return textPart;
    }

    @Override
    public TextPart replaceWordWithSubstring(TextPart textPart, int wordLength, String subString) throws ServiceException {
        if (textPart ==null || wordLength <= 0 || subString == null || subString.trim().isEmpty()){
            throw new ServiceException("Invalid parameter");
        }
        for (TextPart paragraph : textPart.getParts()) {
            for (TextPart sentence : paragraph.getParts()) {
                for (TextPart word : sentence.getParts()) {
                    if (word.toString().length() == wordLength){
                        word.setPart(new Word(subString));
                    }
                }
            }
        }
        return textPart;
    }
}
