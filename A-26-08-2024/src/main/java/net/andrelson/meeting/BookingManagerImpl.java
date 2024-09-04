package net.andrelson.meeting;

import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;
import net.andrelson.meeting.model.MeetingRoom;
import net.andrelson.meeting.model.MeetingType;

import java.time.LocalDateTime;
import java.util.Set;

public class BookingManagerImpl implements BookingManager{

    private final MeetingManager meetingManager;

    public BookingManagerImpl(MeetingManager meetingManager) {
        this.meetingManager = meetingManager;
    }

    @Override
    public MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants,
                                       MeetingType meetingType) throws UnvailableBookingException {

        MeetingRoom meetingRoomAvailable = meetingManager.getMeetingsRooms()
                .stream()
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
        MeetingRoom meetingRoomToCancelBook = meetingManager.getMeetingsRooms()
                .stream()
                .filter(mr -> mr.equals(meetingRoom))
                .findFirst()
                .orElseThrow(()-> new MeetingRoomNotFoundException());

        meetingRoomToCancelBook.removeMeeting(bookingDate);
    }

    @Override
    public void cancelBookMeetingRoom(int MeetingRoomNumber, LocalDateTime cancelDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException {
        MeetingRoom meetingRoom = meetingManager.getMeetingsRooms()
                .stream()
                .filter(mr -> mr.getMeetingRoomNumber() == MeetingRoomNumber)
                .findFirst()
                .orElseThrow(()-> new MeetingRoomNotFoundException("The meeting room number: " + MeetingRoomNumber + "does not exist"));

        meetingRoom.removeMeeting(cancelDate);
    }

    @Override
    public MeetingRoom editReservation(int meetingRoomNumber, LocalDateTime oldDate, LocalDateTime newDate)  throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException {
        MeetingRoom meetingRoom = meetingManager.getMeetingRoom(meetingRoomNumber);

        if(!checkDateReservationExists(meetingRoomNumber, oldDate))
            throw new MeetingRoomReservationNotFoundException("The reservation doesn't exist");

        if(checkDateReservationExists(meetingRoomNumber, newDate))
            throw new UnvailableBookingException("The reservation already exists");


        Set<String> participantsFromOldDate = meetingRoom.getMeetings().get(oldDate);
        meetingRoom.addMeeting(newDate, participantsFromOldDate);

        cancelBookMeetingRoom(meetingRoomNumber, oldDate);

        return meetingRoom;
    }

    private boolean checkDateReservationExists(int meetingRoomNumber, LocalDateTime date) {
         return meetingManager.getMeetingRoom(meetingRoomNumber)
                 .getMeetings()
                 .keySet()
                 .stream()
                 .anyMatch(t -> t.isEqual(date));
    }
}
