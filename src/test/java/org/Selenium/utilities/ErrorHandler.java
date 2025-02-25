package org.Selenium.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorHandler {

    private static final Logger logger = LogManager.getLogger(ErrorHandler.class);

    // Handle a generic exception
    public static void handleError(Exception e) {
        // Log the error message and stack trace
        logger.error("An error occurred: " + e.getMessage(), e);

        // Optionally, print the stack trace (for debugging purposes)
        e.printStackTrace();
    }

    // Handle API-specific errors, such as HTTP status codes
    public static void handleApiError(int statusCode, String responseBody) {
        logger.error("API call failed with status code: {}", statusCode);
        logger.error("Response body: {}", responseBody);
    }

    // Handle network errors (e.g., no internet connection)
    public static void handleNetworkError(Exception e) {
        logger.error("Network error occurred: {}", e.getMessage(), e);
    }

    // Handle custom exceptions (e.g., invalid data or failed validation)
    public static void handleCustomError(String customMessage) {
        logger.error("Custom error: {}", customMessage);
    }
}

