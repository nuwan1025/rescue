package com.nuwank.rescue.service;

import com.nuwank.rescue.utils.AppConfigConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Incident validator call method
 */
@Component
public class IncidentValidatorCallerImpl implements IncidentValidatorCaller {

    private static final Logger LOGGER = LoggerFactory.getLogger(IncidentValidatorCallerImpl.class);

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value(AppConfigConstants.VALIDATION_API)
    private String validationUrl;

    @Value(AppConfigConstants.VALIDATION_API_CALL_READ_TIMEOUT)
    private int readTimeout;

    @Value(AppConfigConstants.VALIDATION_API_CALL_CONNECT_TIMEOUT)
    private int connectionTimeout;

    /**
     * Incident validation call.
     * @param referenceId reference id of incident
     */
    @Override
    public void validateIncident(String referenceId) {
        RestTemplate restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
                .setReadTimeout(Duration.ofMillis(readTimeout))
                .build();
        try {
            restTemplate.getForObject(validationUrl, String.class);
        } catch (RestClientException e) {
            LOGGER.error("Validation API trigger failed. ReferenceId: {}", referenceId);
        }
    }
}
