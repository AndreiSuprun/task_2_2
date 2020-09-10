package com.suprun.textparser.dao.impl;

import com.suprun.textparser.dao.DaoException;
import com.suprun.textparser.dao.TextParsingDao;
import com.suprun.textparser.entity.TextPart;
import com.suprun.textparser.dao.parser.Parser;
import com.suprun.textparser.dao.parser.TextParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TextParsingDaoImpl implements TextParsingDao {

    private static final String RESOURCE_FILE = "properties.file";
    private static final String FILE_NAME = "filename";

    @Override
    public TextPart receiveParsedText() throws DaoException {
        String text = receiveTextFromFile();
        Parser textParser = TextParser.getInstance();
        TextPart parsedText = textParser.parse(text);
        return parsedText;
    }

    private String receiveTextFromFile() throws DaoException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_FILE);
        String fileName = resourceBundle.getString(FILE_NAME);
        Path path;
        String text;
        try {
            path = Path.of(fileName);
        } catch (InvalidPathException e) {
            throw new DaoException(e.getMessage(), e);
        }
        try {
            text = Files.readAllLines(path).stream().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return text;
    }
}
