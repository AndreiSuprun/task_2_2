package com.suprun.textparser.entity;

import java.util.stream.Collectors;

public class Text extends CompositePart{

    private static final String EMPTY_STRING = "";

    @Override
    public String toString() {
        return getParts().stream().map(TextPart::toString).collect(Collectors.joining(EMPTY_STRING)).concat(System.lineSeparator());
    }
}
