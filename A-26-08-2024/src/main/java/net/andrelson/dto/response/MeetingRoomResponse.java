package net.andrelson.dto.response;

import net.andrelson.meeting.model.MeetingRoom;
import net.andrelson.meeting.model.MeetingType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public record MeetingRoomResponse(
        int meetingRoomNumber,
        Map<LocalDateTime, Set<String>> meetings,
        MeetingType meetingType
) {
    public MeetingRoomResponse(MeetingRoom meetingRoom) {
        this(meetingRoom.getMeetingRoomNumber(), meetingRoom.getMeetings(), meetingRoom.getMeetingType());
    }
}
