package net.andrelson.meeting.exception;

public class MeetingRoomNotFoundException extends Throwable{

	public MeetingRoomNotFoundException() {
		super();
	}

	public MeetingRoomNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MeetingRoomNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MeetingRoomNotFoundException(String message) {
		super(message);
	}

	public MeetingRoomNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
