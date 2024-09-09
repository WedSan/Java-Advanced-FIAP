package net.andrelson.dto.response;

import net.andrelson.meeting.model.MeetingRoom;

import java.util.Map;

public record TotalParticipantsMeetingRoom(
        MeetingRoomResponse meetingRoomResponse,
        int totalParticipants
) {
}
