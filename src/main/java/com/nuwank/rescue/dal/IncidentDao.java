package com.nuwank.rescue.dal;

import com.nuwank.rescue.exception.IncidentDaoException;
import com.nuwank.rescue.pojo.Incident;

/**
 * Dao interface for Incident persistence
 */
public interface IncidentDao {
    /**
     * Inserts record to db
     *
     * @param incident incident to save
     * @return incident id
     * @throws IncidentDaoException if exception occured while saving
     */
    int save(Incident incident) throws IncidentDaoException;
}
