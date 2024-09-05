package net.andrelson.meeting.service;

import java.util.List;

import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.model.MeetingRoom;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MeetingRoomManagerImpl implements MeetingRoomManager {
	
	private List<MeetingRoom> meetingRooms;

	public MeetingRoomManagerImpl(List<MeetingRoom> meetingRooms) {
		this.meetingRooms = meetingRooms;
	}

	@Override
	public void addMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistsException {
		if(meetingRooms.contains(meetingRoom)){
			throw new MeetingRoomAlreadyExistsException("The meeting room number: " + meetingRoom.getMeetingRoomNumber() + "already exists");
		}
		meetingRooms.add(meetingRoom);
	}

	@Override
	public List<MeetingRoom> getMeetingsRooms() {
		return meetingRooms;
	}

	@Override
	public MeetingRoom getMeetingRoom(int meetingRoomNumber) throws MeetingRoomNotFoundException {
		return meetingRooms.stream()
				.filter(meetingRoom -> meetingRoom.getMeetingRoomNumber() == meetingRoomNumber)
				.findFirst()
				.orElseThrow(()-> new MeetingRoomNotFoundException("The meeting room number: " + meetingRoomNumber + "does not exist"));
	}
}
