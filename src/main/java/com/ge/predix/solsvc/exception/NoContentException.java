package com.ge.predix.solsvc.exception;

/**
 * Use this exception if bad request is detected.
 */
public class NoContentException extends ServiceException {

    /**
     * serial id.
     */
    private static final long serialVersionUID = 7907495768452192020L;

    /**
     * Constructor.
     * @param message exception message.
     * @param cause of the exception.
     */
    public NoContentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * @param message exception message.
     */
    public NoContentException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     * @param cause cause of the exception.
     */
    public NoContentException(final Throwable cause) {
        super(cause);
    }
}
