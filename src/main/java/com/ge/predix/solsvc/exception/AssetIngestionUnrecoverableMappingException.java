package com.ge.predix.solsvc.exception;

/**
 * The exception class to use when a mapping failed and is unrecoverable.
 * @author 212472184
 *
 */
public class AssetIngestionUnrecoverableMappingException extends RuntimeException {
    /**
     * Empty constructor.
     */
    public AssetIngestionUnrecoverableMappingException() {
        super();
    }

    /**
     * String constructor.
     * @param message .
     */
    public AssetIngestionUnrecoverableMappingException(final String message) {
        super(message);
    }

    /**
     * String, Throwable constructor.
     * @param message .
     * @param cause .
     */
    public AssetIngestionUnrecoverableMappingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Throwable constructor.
     * @param cause .
     */
    public AssetIngestionUnrecoverableMappingException(final Throwable cause) {
        super(cause);
    }
}
