package net.andrelson.dto.request;

import net.andrelson.meeting.model.MeetingType;

public record MeetingRoomCreationRequest(
    int meetingRoomNumber,
    MeetingType meetingRoomType
) {
}
