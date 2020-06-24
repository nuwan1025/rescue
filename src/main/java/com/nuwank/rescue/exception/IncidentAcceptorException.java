package com.nuwank.rescue.exception;

public class IncidentAcceptorException extends Exception{
    /**
     * Constructor to instantiate a IncidentAcceptorException.
     */
    public IncidentAcceptorException() {
        // This is the default constructor. Thus the implementation is empty.
    }

    /**
     * Constructor to instantiate a IncidentAcceptorException with message.
     */
    public IncidentAcceptorException(String message) {
        super(message);
    }

    /**
     * Constructor to instantiate a IncidentAcceptorException with message and cause.
     */
    public IncidentAcceptorException(String message, Throwable cause) {
        super(message, cause);
    }

}
