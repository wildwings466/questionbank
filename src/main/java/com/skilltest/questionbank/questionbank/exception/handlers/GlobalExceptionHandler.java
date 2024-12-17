package com.skilltest.questionbank.questionbank.exception.handlers;

import com.skilltest.questionbank.questionbank.exception.NotFoundException;
import com.skilltest.questionbank.questionbank.exception.QuestionBankException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


	public static final String ERROR_OCCURRED = "Error occurred: ";

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>("No Such Element Found", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>("Json parse error: Unable to deserialize.", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<String> pSQLExceptionHandler(PSQLException ex){
		log.info(ex.getClass().getName() + ": " + Objects.requireNonNull(ex.getServerErrorMessage()).getDetail());
		return new ResponseEntity<>(ex.getServerErrorMessage().getDetail(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(QuestionBankException.class)
	public ResponseEntity<String> handleQuestionBankException(QuestionBankException ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		Throwable cause = ex.getCause();
		if (cause != null && cause.getCause() instanceof PSQLException internalCause) {
				return pSQLExceptionHandler( internalCause);
		}
		return new ResponseEntity<>(ERROR_OCCURRED + ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> constraintViolationExceptionHandler(ConstraintViolationException ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		Throwable cause = ex.getCause();
		if (cause != null && cause.getCause() instanceof PSQLException internalCause) {
				return pSQLExceptionHandler( internalCause);
		}
		return new ResponseEntity<>(ERROR_OCCURRED + ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		log.info(ex.getClass().getName() + ": " + ex.getMessage());
		return new ResponseEntity<>(ERROR_OCCURRED + ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
