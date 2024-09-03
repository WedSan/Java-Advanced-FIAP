package net.andrelson.meeting;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;

public interface MeetingManager {

	void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;

	MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants, MeetingType meetingType) throws UnvailableBookingException ;
	
	void cancelBookMeetingRoom(MeetingRoom meetingRoom, LocalDateTime cancelDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException;

	void cancelBookMeetingRoom(int meetingRoomNumber, LocalDateTime cancelDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException;

	void editReservation(int meetingRoomNumber, LocalDateTime oldDate, LocalDateTime newDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException;

	List<MeetingRoom> getMeetingsRooms();

	MeetingRoom getMeetingRoom(int meetingRoomNumber) throws MeetingRoomNotFoundException;
}
