package edu.iu.habahram.databsedemo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Relationship {
    MOTHER("Mother"),
    FATHER("Father"),
    WIFE("Wife"),
    HUSBAND("Husband"),
    BOSS("Boss"),
    PROFESSOR("Professor");


    private final String displayName;


    private Relationship(String displayName) {
        this.displayName = displayName;
    }

    @JsonCreator
    public static Relationship fromText(String text) {
        for (Relationship relationship : Relationship.values()) {
            if (relationship.toString().equalsIgnoreCase(text)) {
                return relationship;
            }
        }
        return null;
    }

    public String getDisplayName() {
        return displayName;
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
