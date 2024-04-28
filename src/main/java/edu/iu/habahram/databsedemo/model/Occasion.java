package edu.iu.habahram.databsedemo.model;

public enum Occasion {
    MOTHERS_DAY("Mother's Day"),
    BIRTHDAY("Birthday"),
    THANK_YOU("Thank You");

    private String displayName;

    private Occasion(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
