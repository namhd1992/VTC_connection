/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.connection.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vtc.connection.common.dto.response.ConnectionScoinResponse;
import com.vtc.connection.common.dto.response.ScoinResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Oct 11, 2018
 */
@ControllerAdvice
@Slf4j
public class ScoinExceptionHandler extends ResponseEntityExceptionHandler {
  
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinBusinessException.class)
    public ResponseEntity<ScoinResponse<String>> handleSplayBusinessException(final HttpServletRequest request,
                                                                              final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinBusinessException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinInvalidDataRequestException.class)
    public ResponseEntity<ScoinResponse<String>> handleInvalidInputException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinInvalidDataRequestException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ConnectionScoinInvalidDataRequestException.class)
    public ResponseEntity<ConnectionScoinResponse<String>> handleInvalidInputExceptionConnectionScoin(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ConnectionScoinResponse<String> response = new ConnectionScoinResponse<String>();
        response.setErrorCode(((ConnectionScoinInvalidDataRequestException) e).getErrorCode());
        response.setErrorDesc(e.getMessage());
        return new ResponseEntity<ConnectionScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinNotFoundEntityException.class)
    public ResponseEntity<ScoinResponse<Object>> handleNotFoundException(final HttpServletRequest request,
                                                                         final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<Object> response = new ScoinResponse<Object>();
        response.setStatus(((ScoinNotFoundEntityException) e).getStatus());
        response.setMessage(e.getMessage());
        response.setData(((ScoinNotFoundEntityException) e).getData());
        return new ResponseEntity<ScoinResponse<Object>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinUnAuthorizationException.class)
    public ResponseEntity<ScoinResponse<String>> handleUnauthorizedException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinUnAuthorizationException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ConnectionScoinUnAuthorizationException.class)
    public ResponseEntity<ConnectionScoinResponse<String>> handleUnauthorizedExceptionConnectionScoin(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(),e);
        ConnectionScoinResponse<String> response = new ConnectionScoinResponse<String>();
        response.setErrorCode(((ConnectionScoinUnAuthorizationException)e).getErrorCode());
        response.setErrorDesc(e.getMessage());
        return new ResponseEntity<ConnectionScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinFailedToExecuteException.class)
    public ResponseEntity<ScoinResponse<String>> handleFailedToExecuteException(final HttpServletRequest request,
                                                                     final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinFailedToExecuteException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinDuplicateEntityException.class)
    public ResponseEntity<ScoinResponse<String>> handleDuplicateEntityException(final HttpServletRequest request,
                                                                                final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinDuplicateEntityException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ConnectionScoinDuplicateEntityException.class)
    public ResponseEntity<ConnectionScoinResponse<String>> handleDuplicateEntityExceptionConectionScoin(final HttpServletRequest request,
                                                                     final Exception e) {
        log.info(e.getMessage(),e);
        ConnectionScoinResponse<String> response = new ConnectionScoinResponse<String>();
        response.setErrorCode(((ConnectionScoinDuplicateEntityException)e).getErrorCode());
        response.setErrorDesc(e.getMessage());
        return new ResponseEntity<ConnectionScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinNotEnoughtException.class)
    public ResponseEntity<ScoinResponse<Object>> handleNotEnoughtException(final HttpServletRequest request,
                                                                           final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<Object> response = new ScoinResponse<Object>();
        response.setStatus(((ScoinNotEnoughtException) e).getStatus());
        response.setMessage(e.getMessage());
        response.setData(((ScoinNotEnoughtException) e).getData());
        return new ResponseEntity<ScoinResponse<Object>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ConnectionScoinNotEnoughtException.class)
    public ResponseEntity<ConnectionScoinResponse<String>> handleNotEnoughtExceptionConectionScoin(final HttpServletRequest request,
                                                                     final Exception e) {
        log.info(e.getMessage(),e);
        ConnectionScoinResponse<String> response = new ConnectionScoinResponse<String>();
        response.setErrorCode(((ConnectionScoinNotEnoughtException)e).getErrorCode());
        response.setErrorDesc(e.getMessage());
        return new ResponseEntity<ConnectionScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinUnknownErrorException.class)
    public ResponseEntity<ScoinResponse<String>> handleUnknownErrorException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinUnknownErrorException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }
    
    /**
     * 
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ScoinTimingStartAndEndException.class)
    public ResponseEntity<ScoinResponse<String>> handleTimingStartAndEndException(final HttpServletRequest request,
                                                                             final Exception e) {
        log.info(e.getMessage(), e);
        ScoinResponse<String> response = new ScoinResponse<String>();
        response.setStatus(((ScoinTimingStartAndEndException) e).getStatus());
        response.setMessage(e.getMessage());
        return new ResponseEntity<ScoinResponse<String>>(response, null, HttpStatus.OK);
    }

}
