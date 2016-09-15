package com.ge.predix.solsvc.exception;

import java.io.Serializable;


/**
 * Response to send if error occurs while calling service.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class ErrorInfo implements Serializable {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = -8145813211988873874L;
    /**
     * Timestamp.
     */
    private long timestamp;
    /**
     * Status.
     */
    private int status;
    /**
     * Error code.
     */
    private String error;
    /**
     * Detail message.
     */
    private String message;
    /**
     * Serice path.
     */
    private String path;

    /**
     * Constructor.
     * @param httpStatus http status to output.
     * @param code error code.
     * @param errorMessage error message.
     * @param servicePath service path.
     */
    public ErrorInfo(final int httpStatus, final String code, final String errorMessage, final String servicePath) {
        this.error = code;
        this.message = errorMessage;
        this.timestamp = System.currentTimeMillis();
        this.status = httpStatus;
        this.path = servicePath;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
