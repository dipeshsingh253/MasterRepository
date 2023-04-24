package com.usermanagement.models;

public enum Designation {
    MANAGER("Manager"),
    COMANAGER("Comanager"),
    WORKER("Worker");
    private final String designation;

    Designation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
