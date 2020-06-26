package com.nuwank.rescue.dal;

import com.nuwank.rescue.exception.IncidentDaoException;
import com.nuwank.rescue.pojo.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DAO layer class managing persistence of Incidents
 */
@Component
public class IncidentDaoImpl implements IncidentDao {

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public String save(Incident incident) throws IncidentDaoException {
        try {
            Incident savedIncident = incidentRepository.save(incident);
            return savedIncident.getId();
        } catch (RuntimeException e) {
            //Since no specific exception. Has to catch the runtime exception to stop exception propagating to upper layers
            throw new IncidentDaoException("Exception occurred while saving incident", e);
        }
    }
}
