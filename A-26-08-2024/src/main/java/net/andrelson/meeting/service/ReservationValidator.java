package net.andrelson.meeting.service;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservationValidator {

    private MeetingRoomManager meetingManager;

    public ReservationValidator(MeetingRoomManager meetingRoomManager) {
        this.meetingManager = meetingRoomManager;
    }

    public boolean doesReservationExist(int meetingRoomNumber, LocalDateTime reservationDate) {
        return meetingManager.getMeetingRoom(meetingRoomNumber)
                .getMeetings()
                .keySet()
                .stream()
                .anyMatch(t -> t.isEqual(reservationDate));
    }
}
