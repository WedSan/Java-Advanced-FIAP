package net.andrelson.dto.request;

import net.andrelson.meeting.MeetingType;

import java.time.LocalDateTime;
import java.util.Set;

public record MeetingRoomBookingRequest(
        LocalDateTime meetingDate,
        Set<String> participantsName,
        MeetingType meetingType
) {
}
