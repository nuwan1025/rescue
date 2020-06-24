package com.nuwank.rescue.service;

import com.nuwank.rescue.dal.IncidentDao;
import com.nuwank.rescue.dal.IncidentIncidentDaoImpl;
import com.nuwank.rescue.exception.IncidentAcceptorException;
import com.nuwank.rescue.exception.IncidentDaoException;
import com.nuwank.rescue.pojo.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Responsible accepting and validating a reported incident
 */
@Component
public class IncidentAcceptorImpl implements IncidentAcceptor {

    @Autowired
    private IncidentDao incidentDao;

    /**
     * Saves the given incident in db
     *
     * @param incident incident to be saved
     *
     * @return saves the incident
     */
    @Override
    public Integer saveIncident(Incident incident) throws IncidentAcceptorException{
        try {
            return incidentDao.save(incident);
        } catch (IncidentDaoException e) {
            throw new IncidentAcceptorException("Exception at saving incident", e);
        }
    }

    @Override
    public void validateIncidents() {

    }
}
