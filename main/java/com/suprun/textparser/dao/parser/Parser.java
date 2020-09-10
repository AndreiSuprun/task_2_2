package com.suprun.textparser.dao.parser;

import com.suprun.textparser.entity.TextPart;

public interface Parser {
    public static final String REGEX_PARAGRAPH_SELECTOR = ".*[\\r\\n]+";
    public static final String REGEX_SENTENCE_SELECTOR = "[A-Z][^\\.\\!\\?]+[\\.\\!\\?]";
    public static final String REGEX_WORD_SELECTOR = "\\b[\\w']+\\b";
    public static final String REGEX_PUNCTUATION_SELECTOR = "\\p{Punct}";
    public static final String REGEX_LEAF_SELECTOR = REGEX_WORD_SELECTOR +"|"+REGEX_PUNCTUATION_SELECTOR;

    TextPart parse(String text);
}
