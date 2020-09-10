package com.suprun.textparser.entity;

import java.util.List;

public interface TextPart {

       List<TextPart> getParts();
       void setPart(TextPart textPart);
       String toString();
}
