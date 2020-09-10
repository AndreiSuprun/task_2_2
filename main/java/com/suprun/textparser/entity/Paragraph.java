package com.suprun.textparser.entity;

import java.util.stream.Collectors;

public class Paragraph extends CompositePart {

    private static final String EMPTY_STRING = "";

    @Override
    public String toString() {
        return getParts().stream().map(TextPart::toString).collect(Collectors.joining(EMPTY_STRING));
    }
}