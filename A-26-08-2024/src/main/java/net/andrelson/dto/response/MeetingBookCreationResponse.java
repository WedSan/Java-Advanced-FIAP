package net.andrelson.dto.response;

import net.andrelson.meeting.MeetingType;

import java.time.LocalDateTime;
import java.util.Set;

public record MeetingBookCreationResponse(
        LocalDateTime meetingDate,
        Set<String> participantsName,
        MeetingType meetingType
) {
}
