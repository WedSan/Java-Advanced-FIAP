package net.andrelson.meeting;

import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;
import net.andrelson.meeting.model.MeetingRoom;
import net.andrelson.meeting.model.MeetingType;

import java.time.LocalDateTime;
import java.util.Set;

public interface BookingManager {
    MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants, MeetingType meetingType) throws UnvailableBookingException;

    void cancelBookMeetingRoom(MeetingRoom meetingRoom, LocalDateTime cancelDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException;

    void cancelBookMeetingRoom(int meetingRoomNumber, LocalDateTime cancelDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException;

    MeetingRoom editReservation(int meetingRoomNumber, LocalDateTime oldDate, LocalDateTime newDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException;

}
