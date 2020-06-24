package com.nuwank.rescue.service.incidentvalidator;

import com.nuwank.rescue.pojo.Incident;

/**
 * Service to validate the incident
 */
public interface IncidentValidator {

    /**
     * Mark a incident as valid or invalid.
     *
     * @param incident incident to be validated
     */
    void validateIncident(Incident incident, boolean valid);
}
