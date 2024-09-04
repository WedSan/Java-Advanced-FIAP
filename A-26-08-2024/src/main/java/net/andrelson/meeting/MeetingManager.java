package net.andrelson.meeting;

import java.util.List;

import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.model.MeetingRoom;

public interface MeetingManager {

	void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;

	List<MeetingRoom> getMeetingsRooms();

	MeetingRoom getMeetingRoom(int meetingRoomNumber) throws MeetingRoomNotFoundException;
}
