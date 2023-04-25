package com.usermanagement.entity;

public enum Designation {
    MANAGER("MANAGER"),
    COMANAGER("COMANAGER"),
    WORKER("WORKER");
    private final String designation;

    Designation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
