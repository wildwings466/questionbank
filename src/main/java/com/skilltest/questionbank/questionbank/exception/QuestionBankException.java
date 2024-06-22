package com.skilltest.questionbank.questionbank.exception;

public class QuestionBankException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public QuestionBankException() {
		super();
	}
	
	public QuestionBankException(String message) {
		super(message);
	}
	
	public QuestionBankException(String message, Throwable cause) {
		super(message, cause);
	}

}
