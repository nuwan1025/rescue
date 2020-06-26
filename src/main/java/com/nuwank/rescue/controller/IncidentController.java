package com.nuwank.rescue.controller;

import com.nuwank.rescue.exception.IncidentAcceptorException;
import com.nuwank.rescue.pojo.Incident;
import com.nuwank.rescue.pojo.IncidentStatus;
import com.nuwank.rescue.pojo.InputIncident;
import com.nuwank.rescue.service.IncidentAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class with the incident related Apis
 */
@RestController
public class IncidentController {

    @Autowired
    private IncidentAcceptor incidentAcceptor;

    private static final Logger LOGGER = LoggerFactory.getLogger(IncidentController.class);

    /**
     * Saves the incident to the db.
     *
     * @return a ok repose if persisting was successful.
     */
    @PostMapping("/rescue/v1/incidents")
    public ResponseEntity<Object> postIncident(@RequestBody InputIncident inputIncident) {
        String requestId = MDC.get("correlationId");
        try {
            Incident incident = new Incident(inputIncident);
            incident.setIncidentStatus(IncidentStatus.NEW);
            String incidentId = incidentAcceptor.saveIncident(incident);
            LOGGER.info("[RequestId: {}] Incident saving success. IncidentId: {}. Sent by by user: {}", requestId, incidentId, incident.getReporterId());
            return ResponseEntity.ok().body(incidentId);
        } catch (IncidentAcceptorException e) {
            LOGGER.error("[RequestId: {}] Error persisting incident sen by user: {}", requestId, inputIncident.getReporterId(), e);
            return new ResponseEntity<>("Error occurred while saving the Incident", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Incident return by id
     *
     * @param referenceId id of the incident
     * @return
     */
    @GetMapping("/rescue/v1/incidents/{referenceId}")
    public ResponseEntity<Object> getIncidentById(@PathVariable String referenceId) {
        //TODO: Implementation Pending
        return ResponseEntity.ok().body("");
    }
}
