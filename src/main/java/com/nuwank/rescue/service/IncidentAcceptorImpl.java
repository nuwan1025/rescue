package com.nuwank.rescue.service;

import com.nuwank.rescue.dal.IncidentDao;
import com.nuwank.rescue.exception.IncidentAcceptorException;
import com.nuwank.rescue.exception.IncidentDaoException;
import com.nuwank.rescue.pojo.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

/**
 * Responsible accepting and validating a reported incident
 */
@Component
public class IncidentAcceptorImpl implements IncidentAcceptor {

    @Autowired
    private IncidentDao incidentDao;

    @Autowired
    @Qualifier("cachedThreadPoolTaskExecutor")
    private ExecutorService cachedTaskExecutorService;

    @Autowired
    private IncidentValidatorCaller incidentValidatorCaller;

    /**
     * Saves the given incident in db
     *
     * @param incident incident to be saved
     * @return saves the incident
     */
    @Override
    public String saveIncident(Incident incident) throws IncidentAcceptorException {
        try {
            String referenceId = incidentDao.save(incident);
            Runnable runnable = () -> incidentValidatorCaller.validateIncident("refId");
            cachedTaskExecutorService.execute(runnable);
            return referenceId;
        } catch (IncidentDaoException e) {
            throw new IncidentAcceptorException("Exception at saving incident", e);
        }
    }
}
