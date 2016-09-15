package com.ge.predix.solsvc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Rest exception processor.
 */
@ControllerAdvice
public class RestExceptionProcessor {

    /**
     * Unknown error.
     * @param req request.
     * @param ex exception.
     * @return ErrorInfo.
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorInfo serverError(final HttpServletRequest req, final RuntimeException ex) {
        return new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorCodes.UNKNOWN_ERROR.name(), ex.getMessage(),
                req.getRequestURI());
    }

    /**
     * Bad request error.
     * @param req request.
     * @param ex exception.
     * @return ErrorInfo.
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo badRequest(final HttpServletRequest req, final RuntimeException ex) {
        return new ErrorInfo(HttpStatus.BAD_REQUEST.value(), ErrorCodes.INVALID_REQUEST.name(), ex.getMessage(),
                req.getRequestURI());
    }

/**
     * No content error.
     * @param req request.
     * @param ex exception.
     */
    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ResponseBody
    public ErrorInfo noConent(final HttpServletRequest req, final RuntimeException ex) {
      // System.out.println("No data for the request::" + ex.getMessage());
       return new ErrorInfo(HttpStatus.NO_CONTENT.value(), ErrorCodes.NO_DATA.name(), ex.getMessage(),
               req.getRequestURI());
    }
}
