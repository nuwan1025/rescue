package com.nuwank.rescue.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Pojo object for Incident
 */
@Document(collection = "incidents")
public class Incident {
    private String id;
    private String description;
    private String location;
    private String tags;
    private LocalDateTime incidentTime;
    private List<Requirement> requirementList;
    private IncidentStatus incidentStatus;

    private int reporterId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public LocalDateTime getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(LocalDateTime incidentTime) {
        this.incidentTime = incidentTime;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Incident incident = (Incident) o;

        return new EqualsBuilder()
                .append(id, incident.id)
                .append(reporterId, incident.reporterId)
                .append(description, incident.description)
                .append(location, incident.location)
                .append(tags, incident.tags)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(description)
                .append(location)
                .append(tags)
                .append(reporterId)
                .toHashCode();
    }

    public Incident(InputIncident inputIncident) {
        this.id = UUID.randomUUID().toString();
        this.description = inputIncident.getDescription();
        this.location = inputIncident.getDescription();
        this.tags = inputIncident.getTags();
        this.incidentTime = inputIncident.getIncidentTime();
        this.reporterId = inputIncident.getReporterId();
        this.requirementList = inputIncident.getRequirementList();
    }
}
