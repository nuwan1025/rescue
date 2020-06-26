package com.nuwank.rescue.service;

import com.nuwank.rescue.exception.IncidentAcceptorException;
import com.nuwank.rescue.pojo.Incident;

/**
 * Responsible accepting and validating a reported service
 */
public interface IncidentAcceptor {

    /**
     * Saves the given incident in db
     *
     * @param incident incident to be saved
     *
     * @return saves the incident's id
     */
    String saveIncident(Incident incident) throws IncidentAcceptorException;
}
