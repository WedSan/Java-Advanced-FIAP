package net.andrelson.dto.request;

import net.andrelson.meeting.MeetingType;

import java.time.LocalDate;

public record MeetingRoomCreationRequest(
    int meetingRoomNumber,
    MeetingType meetingRoomType
) {
}
