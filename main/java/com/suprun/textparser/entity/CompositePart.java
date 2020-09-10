package com.suprun.textparser.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositePart implements TextPart{

    private List<TextPart> list = new ArrayList<>();

    @Override
    public List<TextPart> getParts() {
        return list;
    }

    @Override
    public void setPart(TextPart textPart) {
        list.add(textPart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompositePart that = (CompositePart) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
