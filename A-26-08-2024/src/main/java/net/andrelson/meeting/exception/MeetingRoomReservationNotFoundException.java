package net.andrelson.meeting.exception;

public class MeetingRoomReservationNotFoundException extends RuntimeException{
    public MeetingRoomReservationNotFoundException() {
    }

    public MeetingRoomReservationNotFoundException(String message) {
        super(message);
    }

    public MeetingRoomReservationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingRoomReservationNotFoundException(Throwable cause) {
        super(cause);
    }

    public MeetingRoomReservationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
