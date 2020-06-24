package com.nuwank.rescue.dal;

import com.nuwank.rescue.pojo.Incident;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {}
