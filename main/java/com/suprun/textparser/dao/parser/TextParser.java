package com.suprun.textparser.dao.parser;

import com.suprun.textparser.entity.Text;
import com.suprun.textparser.entity.TextPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements Parser{

    private static TextParser instance;

    private TextParser(){};

    public static TextParser getInstance(){
        if (instance == null){
            instance = new TextParser();
        }
        return instance;
    }

    private Parser nextParser = new ParagraphParser();

    public TextPart parse(String text){
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH_SELECTOR);
        Matcher matcher = pattern.matcher(text);
        TextPart textPart = new Text();
        while(matcher.find()){
            textPart.setPart(nextParser.parse(matcher.group()));
        }
        return textPart;
    }
}
