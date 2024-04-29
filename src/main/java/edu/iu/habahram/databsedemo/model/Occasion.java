package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Occasion {
    MOTHERS_DAY("Mother's Day"),
    BIRTHDAY("Birthday"),
    THANK_YOU("Thank You");

    private String displayName;

    private Occasion(String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator
    public static Occasion fromText(String text) {
        for (Occasion occasion : Occasion.values()) {
            if (occasion.toString().equalsIgnoreCase(text)) {
                return occasion;
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
