package net.andrelson.meeting;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;
import org.springframework.stereotype.Component;

@Component
public class MeetingRoomManagerImpl implements MeetingManager {
	
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
	public MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants,
			MeetingType meetingType) throws UnvailableBookingException{

		MeetingRoom meetingRoomAvailable = meetingRooms.stream()
				.filter(m -> m.getMeetingType().equals(meetingType))
				.filter(m -> m.getMeetings().keySet().stream()
						.noneMatch(t -> t.isEqual(bookingDate)))
				.findFirst()
				.orElseThrow(() -> new UnvailableBookingException());

		meetingRoomAvailable.addMeeting(bookingDate, meetingParticipants);
		return meetingRoomAvailable;
	}

	@Override
	public void cancelBookMeetingRoom(MeetingRoom meetingRoom, LocalDateTime bookingDate)
			throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException {
		MeetingRoom meetingRoomToCancelBook = meetingRooms.stream()
		.filter(mr -> mr.equals(meetingRoom))
		.findFirst()
		.orElseThrow(()-> new MeetingRoomNotFoundException());

		meetingRoomToCancelBook.removeMeeting(bookingDate);
	}

	@Override
	public List<MeetingRoom> getMeetingsRooms() {
		return meetingRooms;
	}
	
	
	
}
