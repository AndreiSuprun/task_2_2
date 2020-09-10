package com.suprun.textparser.entity;

import java.util.List;

public class Punctuation implements TextPart{

    private String punctuation;

    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public List<TextPart> getParts() {
        return null;
    }

    @Override
    public void setPart(TextPart textPart) {
        this.punctuation = textPart.toString();
    }

    @Override
    public String toString() {
        return punctuation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punctuation that = (Punctuation) o;

        return punctuation != null ? punctuation.equals(that.punctuation) : that.punctuation == null;
    }

    @Override
    public int hashCode() {
        return punctuation != null ? punctuation.hashCode() : 0;
    }
}
