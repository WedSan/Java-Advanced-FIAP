package net.andrelson.meeting.exception;

public class MeetingRoomAlreadyExistsException extends Exception {

    public MeetingRoomAlreadyExistsException() {
    }

    public MeetingRoomAlreadyExistsException(String message) {
        super(message);
    }

    public MeetingRoomAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingRoomAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public MeetingRoomAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
