package com.skilltest.questionbank.questionbank.exception.handlers;

import java.util.NoSuchElementException;
import java.util.Set;

import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.skilltest.questionbank.questionbank.exception.QuestionBankException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class QuestionBankExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(QuestionBankExceptionHandler.class);
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException ex){
		logger.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>("No Such Element Found", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex){
		logger.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>("Json parse error: Unable to deserialize.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<String> pSQLExceptionHandler(PSQLException ex){
		logger.info(ex.getClass().getName() + ": " + ex.getServerErrorMessage().getDetail());
		return new ResponseEntity<>(ex.getServerErrorMessage().getDetail(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(QuestionBankException.class)
	public ResponseEntity<String> handleQuestionBankException(QuestionBankException ex){
		logger.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex){
		logger.info(ex.getClass().getName() + ": " + ex.getMessage());
		Throwable cause = ex.getCause();
		if (cause != null) {
			Throwable internalCause = cause.getCause();
			if (internalCause instanceof PSQLException) {
				return pSQLExceptionHandler((PSQLException) internalCause);
			}
		}
		return new ResponseEntity<>("Error occurred: " + ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException ex){
		Set<ConstraintViolation<?>> constraintVoilations= ex.getConstraintViolations();
		logger.info(ex.getClass().getName() + ": " + ex.getMessage());
		Throwable cause = ex.getCause();
		if (cause != null) {
			Throwable internalCause = cause.getCause();
			if (internalCause instanceof PSQLException) {
				return pSQLExceptionHandler((PSQLException) internalCause);
			}
		}
		return new ResponseEntity<>("Error occurred: " + ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		logger.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>("Error occurred: " + ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
