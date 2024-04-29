package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Type {
    MIXED("Mixed"), ROSES("Roses"), LILIES("Lilies"), TULIPS("Tulips"), DAISIES("Daisies");


    private final String displayName;

    private Type(String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator
    public static Type fromText(String text) {
        for (Type type : Type.values()) {
            if (type.toString().equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return displayName;
    }

    @JsonValue
    public String toText() {
        return toString();
    }
}