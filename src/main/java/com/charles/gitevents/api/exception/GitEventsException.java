package com.charles.gitevents.api.exception;

public class GitEventsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private ExceptionType exceptionType;
	
	public GitEventsException(final String message, final Throwable tb, final ExceptionType type) {
		super(message, tb);
		this.setExceptionType(type);
	}
	
	public GitEventsException(final String message, final ExceptionType type) {
		super(message);
		this.setExceptionType(type);
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

}
