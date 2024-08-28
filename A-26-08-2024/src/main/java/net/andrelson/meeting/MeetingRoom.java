package net.andrelson.meeting;

import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class MeetingRoom {

	private int meetingRoomNumber;

	private Map<LocalDateTime, Set<String>> meetings;
	
	private MeetingType meetingType;
	
	public MeetingRoom() {
	}

	public MeetingRoom(int meetingRoomNumber, Map<LocalDateTime, Set<String>> meetings, MeetingType meetingType) {
        this.meetingRoomNumber = meetingRoomNumber;
        this.meetings = meetings;
		this.meetingType = meetingType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MeetingRoom that = (MeetingRoom) o;
		return meetingRoomNumber == that.meetingRoomNumber;
	}

	public int getMeetingRoomNumber() {
		return meetingRoomNumber;
	}

	public void setMeetingRoomNumber(int meetingRoomNumber) {
		this.meetingRoomNumber = meetingRoomNumber;
	}

	public Map<LocalDateTime, Set<String>> getMeetings() {
		return meetings;
	}

	public void setMeetings(Map<LocalDateTime, Set<String>> meetings) {
		this.meetings = meetings;
	}

	public void addMeeting(LocalDateTime start, Set<String> participants) {
		meetings.put(start, participants);
	}

	public void removeMeeting(LocalDateTime meetingStart) throws MeetingRoomReservationNotFoundException {
		meetings.remove(meetingStart);
	}
	public MeetingType getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(MeetingType meetingType) {
		this.meetingType = meetingType;
	}


}
