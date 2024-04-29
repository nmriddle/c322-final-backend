package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Color {
    MIXED("Mixed"), RED("Red"), YELLOW("Yellow"), GREEN("Green"), ORANGE("Orange");

    private final String displayName;

    private Color(String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator
    public static Color fromText(String text) {
        for (Color color : Color.values()) {
            if (color.toString().equalsIgnoreCase(text)) {
                return color;
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