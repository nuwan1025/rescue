package com.nuwank.rescue.utils;

/**
 * Application config constant keys
 */
public class AppConfigConstants {
    public static final String VALIDATION_API = "validation.api";
    public static final String VALIDATION_API_CALL_READ_TIMEOUT = "${validation.api.read.timeout}";
    public static final String VALIDATION_API_CALL_CONNECT_TIMEOUT = "${validation.api.connect.timeout}";

    /**
     * Private constructor to prevent initialization
     */
    private AppConfigConstants() {
    }
}
