package com.nuwank.rescue.service;

/**
 * Incident validator interface
 */
public interface IncidentValidatorCaller {

    /**
     * Calls the validation micro Service
     * @param referenceId reference id of incident
     */
    void validateIncident(String referenceId);
}
