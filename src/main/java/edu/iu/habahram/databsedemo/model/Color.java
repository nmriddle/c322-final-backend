package edu.iu.habahram.databsedemo.model;

public enum Color {
    MIXED("Mixed"),
    RED("Red"),
    YELLOW("Yellow"),
    GREEN("Green"),
    ORANGE("Orange");

    private final String displayName;

    private Color(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}