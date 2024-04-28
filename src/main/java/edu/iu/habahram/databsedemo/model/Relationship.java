package edu.iu.habahram.databsedemo.model;

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

    public String getDisplayName() {
        return displayName;
    }
}
