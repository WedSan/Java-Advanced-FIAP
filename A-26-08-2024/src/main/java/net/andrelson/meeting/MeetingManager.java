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

	List<MeetingRoom> getMeetingsRooms();

	MeetingRoom getMeetingRoom(int meetingRoomNumber) throws MeetingRoomNotFoundException;
}
