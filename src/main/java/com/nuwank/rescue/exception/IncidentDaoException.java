package com.nuwank.rescue.exception;

public class IncidentDaoException extends Exception {
    /**
     * Constructor to instantiate a IncidentDaoException.
     */
    public IncidentDaoException() {
        // This is the default constructor. Thus the implementation is empty.
    }

    /**
     * Constructor to instantiate a IncidentDaoException with message.
     */
    public IncidentDaoException(String message) {
        super(message);
    }

    /**
     * Constructor to instantiate a IncidentDaoException with message and cause.
     */
    public IncidentDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
