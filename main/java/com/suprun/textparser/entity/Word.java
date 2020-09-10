package com.suprun.textparser.entity;

import java.util.List;

public class Word implements TextPart{

    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public List<TextPart> getParts() {
        return null;
    }

    @Override
    public void setPart(TextPart textPart) {
        word = textPart.toString();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word1 = (Word) o;
        return word != null ? word.equals(word1.word) : word1.word == null;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
