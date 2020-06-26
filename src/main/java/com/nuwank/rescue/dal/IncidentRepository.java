package com.nuwank.rescue.dal;

import com.nuwank.rescue.pojo.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Mongo repository used for querying mongo db
 */
public interface IncidentRepository extends MongoRepository<Incident, String> {
}
