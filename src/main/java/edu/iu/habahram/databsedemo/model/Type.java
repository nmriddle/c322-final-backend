package edu.iu.habahram.databsedemo.model;

public enum Type {
    MIXED("Mixed"),
    ROSES("Roses"),
    LILIES("Lilies"),
    TULIPS("Tulips"),
    DAISIES("Daisies");

    private final String displayName;

    private Type(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}