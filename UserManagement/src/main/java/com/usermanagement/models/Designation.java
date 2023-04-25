package com.usermanagement.models;

public enum Designation {
    MANAGER("MANAGER"),
    COMANAGER("CoMANAGER"),
    WORKER("WORKER");
    private final String designation;

    Designation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
