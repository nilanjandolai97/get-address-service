package com.nilanjan.springboot.api.addressService.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilanjan.springboot.api.addressService.service.AddressService;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
		logger.debug("Entering into handleResourceNotFound.");
		Map<String, Object> body = new HashMap<>();
	    body.put("timestamp", LocalDateTime.now());
	    body.put("message", ex.getMessage());
	    body.put("status", 404);
	    logger.error(body.toString());
	    logger.debug("Going out from handleResourceNotFound.");
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
		logger.debug("Entering into handleGeneric.");
		Map<String, Object> body = new HashMap<>();
	    body.put("timestamp", LocalDateTime.now());
	    body.put("message", ex.getMessage());
	    body.put("status", 500);
	    logger.error(body.toString());
	    logger.debug("Going out from handleGeneric.");
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
