package com.nuwank.rescue.service;

import com.nuwank.rescue.dal.IncidentDao;
import com.nuwank.rescue.dal.IncidentDaoImpl;
import com.nuwank.rescue.exception.IncidentAcceptorException;
import com.nuwank.rescue.exception.IncidentDaoException;
import com.nuwank.rescue.pojo.Incident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.concurrent.ExecutorService;

import static org.mockito.Mockito.*;

/**
 * Test class of IncidentAcceptorImpl
 */
class IncidentAcceptorImplTest {
    private IncidentAcceptorImpl incidentAcceptor;
    private Incident incident;
    private ExecutorService cachedTaskExecutorService;
    private IncidentValidatorCaller incidentValidatorCaller;
    private IncidentDao incidentDao;

    @BeforeEach
    void setUp() {
        incidentAcceptor = new IncidentAcceptorImpl();
        incident = mock(Incident.class);
        cachedTaskExecutorService = mock(ExecutorService.class);
        incidentValidatorCaller = mock(IncidentValidatorCaller.class);
        incidentDao = mock(IncidentDaoImpl.class);

        ReflectionTestUtils.setField(incidentAcceptor, "cachedTaskExecutorService", cachedTaskExecutorService);
        ReflectionTestUtils.setField(incidentAcceptor, "incidentValidatorCaller", incidentValidatorCaller);
        ReflectionTestUtils.setField(incidentAcceptor, "incidentDao", incidentDao);
    }

    /**
     * Should save incident and synchronously call incident validator microservice
     */
    @Test
    void should_save_incident_and_call_validator_async_with_reference_id() throws IncidentAcceptorException, IncidentDaoException {
        when(incidentDao.save(incident)).thenReturn("refId");
        incidentAcceptor.saveIncident(incident);

        ArgumentCaptor<Runnable> captor =
                ArgumentCaptor.forClass(Runnable.class);
        verify(cachedTaskExecutorService).execute(captor.capture());
        Runnable lambda = captor.getValue();
        lambda.run();
        verify(incidentValidatorCaller).validateIncident("refId");
    }
}
