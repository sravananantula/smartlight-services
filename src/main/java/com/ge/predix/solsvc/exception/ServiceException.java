package com.ge.predix.solsvc.exception;

/**
 * Exception to throw when something goes awry while calling one of the services.
 */

@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceException extends RuntimeException {
    /**
     * Serial id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Error code.
     */
    private String code;

    /**
     * Constructor.
     * @param errorCode error code
     * @param message error message
     * @param cause real cause of exception.
     */
    public ServiceException(final String errorCode, final String message, final Throwable cause) {
        super(message, cause);
        this.code = errorCode;
    }

    /**
     * Constructor.
     * @param errorCode error code.
     * @param message error message.
     */
    public ServiceException(final String errorCode, final String message) {
        super(message);
        this.code = errorCode;
    }

    /**
     * Constructor.
     * @param message error message.
     * @param cause real cause of exception.
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * @param message error message
     */
    public ServiceException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     * @param cause real cause of exception.
     */
    public ServiceException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     * @param errorCode error code.
     */
    public ServiceException(final ErrorCodes errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.name();
    }

    /**
     * Constructor.
     * @param errorCode error code.
     * @param cause real cause of exception.
     */
    public ServiceException(final ErrorCodes errorCode, final Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.code = errorCode.name();
    }
}
