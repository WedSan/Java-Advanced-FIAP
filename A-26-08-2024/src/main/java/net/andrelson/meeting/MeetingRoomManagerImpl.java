package net.andrelson.meeting;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;


public class MeetingRoomManagerImpl implements MeetingManager {
	
	private List<MeetingRoom> meetingRooms;

	@Override
	public MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants,
			MeetingType meetingType) throws UnvailableBookingException{
		
		return meetingRooms.stream()
		.filter(m -> m.getMeetingType().equals(meetingType))
		.filter(m -> m.getMeetings().keySet().stream()
				.noneMatch(t -> t.isEqual(bookingDate)))
		.findFirst()
		.orElseThrow(() -> new UnvailableBookingException());
	}	

	@Override
	public void cancelBookMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomNotFoundException {
		meetingRooms.stream()
		.filter(mr -> mr.equals(meetingRoom))
		.findFirst()
		.orElseThrow(()-> new MeetingRoomNotFoundException());
	}

	@Override
	public List<MeetingRoom> getMeetingsRooms() {
		return meetingRooms;
	}
	
	
	
}
