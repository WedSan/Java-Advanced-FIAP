package net.andrelson.meeting;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class MeetingRoom {
	private Map<LocalDateTime, Set<String>> meetings;
	
	private MeetingType meetingType;
	
	public MeetingRoom() {
	}

	public MeetingRoom(Map<LocalDateTime, Set<String>> meetings, MeetingType meetingType) {
		this.meetings = meetings;
		this.meetingType = meetingType;
	}

	public Map<LocalDateTime, Set<String>> getMeetings() {
		return meetings;
	}

	public void setMeetings(Map<LocalDateTime, Set<String>> meetings) {
		this.meetings = meetings;
	}

	public MeetingType getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(MeetingType meetingType) {
		this.meetingType = meetingType;
	}
	
	
	

}
