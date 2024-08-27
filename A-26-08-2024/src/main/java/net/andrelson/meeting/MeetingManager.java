package net.andrelson.meeting;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;

public interface MeetingManager {
	MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants, MeetingType meetingType) throws UnvailableBookingException ;
	
	void cancelBookMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomNotFoundException;
	
	List<MeetingRoom> getMeetingsRooms();
}