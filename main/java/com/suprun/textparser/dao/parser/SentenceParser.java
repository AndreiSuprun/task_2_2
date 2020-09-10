package com.suprun.textparser.dao.parser;

import com.suprun.textparser.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements Parser {

    @Override
    public TextPart parse(String text) {
        Pattern leafPattern = Pattern.compile(REGEX_LEAF_SELECTOR);
        Matcher leafMatcher = leafPattern.matcher(text);
        TextPart textPart = new Sentence();
        while (leafMatcher.find()) {
            String groupString = leafMatcher.group();
            textPart.setPart(groupString.matches(REGEX_WORD_SELECTOR)? new Word(groupString) : new Punctuation(groupString));
        }
        return textPart;
    }


}
