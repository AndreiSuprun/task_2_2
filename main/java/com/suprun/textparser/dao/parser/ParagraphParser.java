package com.suprun.textparser.dao.parser;

import com.suprun.textparser.entity.Text;
import com.suprun.textparser.entity.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Parser{

    private Parser nextParser = new SentenceParser();

    public TextPart parse(String text){
        Pattern pattern = Pattern.compile(REGEX_SENTENCE_SELECTOR);
        Matcher matcher = pattern.matcher(text);
        TextPart textPart = new Text();
        while(matcher.find()){
            textPart.setPart(nextParser.parse(matcher.group()));
        }
        return textPart;
    }
}