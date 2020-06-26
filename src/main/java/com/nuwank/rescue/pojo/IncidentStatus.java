package com.nuwank.rescue.pojo;

/**
 * Enum for incident status
 */
public enum IncidentStatus {
    NEW("NEW"),
    VALID("VALID"),
    INVALID("INVALID"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    private String status;

    /**
     * Constructor for enum
     *
     * @param status status
     */
    IncidentStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the get Incident status
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }
}
