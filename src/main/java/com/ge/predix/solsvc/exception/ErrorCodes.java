package com.ge.predix.solsvc.exception;

/**
 * Possible error codes.
 */
public enum ErrorCodes {
    /**
     * Use for invalid request.
     */
    INVALID_REQUEST("Invalid Request"),
    /**
     * Use for unknown errors.
     */
    UNKNOWN_ERROR("Unknown error"),
    /**
     * Use for invalid request.
     */
    NO_DATA("No Data");
    /**
     * String representation of the error.
     */
    private String message;

    /**
     * Constructor.
     * @param errorMessage string representation of the error.
     */
    ErrorCodes(final String errorMessage) {
        this.message = errorMessage;
    }

    /**
     * Returns the string error message.
     * @return error string.
     */
    public String getMessage() {
        return message;
    }
}
