package net.andrelson.meeting.exception;

public class UnvailableBookingException extends RuntimeException{

	public UnvailableBookingException() {
		super();
	}

	public UnvailableBookingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnvailableBookingException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnvailableBookingException(String message) {
		super(message);
	}

	public UnvailableBookingException(Throwable cause) {
		super(cause);
	}
	
}
