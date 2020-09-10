package com.suprun.textparser.entity;

import java.util.List;

public class Sentence extends CompositePart {

    public static final String REGEX_PUNCTUATION_SELECTOR = "\\p{Punct}";
    public static final String WHITE_SPACE = " ";

    @Override
    public String toString() {
        List<TextPart> list = getParts();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< getParts().size()-1; i++){
            if (list.get(i+1).toString().matches(REGEX_PUNCTUATION_SELECTOR)){
              stringBuilder.append(list.get(i).toString());
            } else {
                stringBuilder.append(list.get(i).toString()).append(WHITE_SPACE);
            }
        }
        return stringBuilder.append(list.get(list.size()-1).toString()).toString();
    }
}
