package net.andrelson.meeting.service;

import net.andrelson.meeting.exception.MeetingRoomNotFoundException;
import net.andrelson.meeting.exception.MeetingRoomReservationNotFoundException;
import net.andrelson.meeting.exception.UnvailableBookingException;
import net.andrelson.meeting.model.MeetingRoom;
import net.andrelson.meeting.model.MeetingType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


@Service
public class BookingManagerImpl implements BookingManager{

    private final MeetingRoomManager meetingRoomManager;

    private final ReservationValidator reservationValidator;

    public BookingManagerImpl(MeetingRoomManager meetingRoomManager, ReservationValidator reservationValidator) {
        this.meetingRoomManager = meetingRoomManager;
        this.reservationValidator = reservationValidator;
    }

    @Override
    public int getAllMeetings() {
        return meetingRoomManager.getMeetingsRooms()
                .stream()
                .mapToInt(value -> value.getMeetings().size())
                .sum();
    }

    @Override
    public Map<LocalDateTime, Set<String>> getMeetings(int meetingRoomNumber) {
        Map<LocalDateTime, Set<String>> meetings = meetingRoomManager.getMeetingRoom(meetingRoomNumber)
                .getMeetings();

        return new TreeMap<LocalDateTime, Set<String>>(meetings);
    }

    @Override
    public MeetingRoom bookMeetingRoom(LocalDateTime bookingDate, Set<String> meetingParticipants,
                                       MeetingType meetingType) throws UnvailableBookingException {

        MeetingRoom meetingRoomAvailable = meetingRoomManager.getMeetingsRooms()
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
    public void cancelBookMeetingRoom(int MeetingRoomNumber, LocalDateTime cancelDate) throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException {
        MeetingRoom meetingRoom = meetingRoomManager.getMeetingsRooms()
                .stream()
                .filter(mr -> mr.getMeetingRoomNumber() == MeetingRoomNumber)
                .findFirst()
                .orElseThrow(()-> new MeetingRoomNotFoundException("The meeting room number: " + MeetingRoomNumber + "does not exist"));

        meetingRoom.removeMeeting(cancelDate);
    }

    @Override
    public MeetingRoom editReservation(int meetingRoomNumber, LocalDateTime oldDate, LocalDateTime newDate)  throws MeetingRoomNotFoundException, MeetingRoomReservationNotFoundException {
        MeetingRoom meetingRoom = meetingRoomManager.getMeetingRoom(meetingRoomNumber);

        if(!reservationValidator.doesReservationExist(meetingRoomNumber, oldDate))
            throw new MeetingRoomReservationNotFoundException("The reservation doesn't exist");

        if(reservationValidator.doesReservationExist(meetingRoomNumber, newDate))
            throw new UnvailableBookingException("The reservation already exists");

        Set<String> participantsFromOldDate = meetingRoom.getMeetings().get(oldDate);
        meetingRoom.addMeeting(newDate, participantsFromOldDate);

        meetingRoom.removeMeeting(oldDate);

        return meetingRoom;
    }
}
