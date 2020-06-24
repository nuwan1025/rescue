package com.nuwank.rescue.dal;

import com.nuwank.rescue.exception.IncidentDaoException;
import com.nuwank.rescue.pojo.Incident;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DAO layer class managing persistence of Incidents
 */
@Component
public class IncidentIncidentDaoImpl implements IncidentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(IncidentIncidentDaoImpl.class);

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public int save(Incident incident) throws IncidentDaoException {
        try {
            Incident savedIncident = incidentRepository.save(incident);
            return savedIncident.getId();
        } catch (HibernateException e) {
            throw new IncidentDaoException("Exception occurred while saving incident", e);
        }
    }
}
