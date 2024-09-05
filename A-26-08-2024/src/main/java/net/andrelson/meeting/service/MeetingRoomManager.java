package net.andrelson.meeting.service;

import java.util.List;

import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.model.MeetingRoom;

public interface MeetingRoomManager {

	void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException;

	List<MeetingRoom> getMeetingsRooms();

	MeetingRoom getMeetingRoom(int meetingRoomNumber) throws MeetingRoomNotFoundException;
}
