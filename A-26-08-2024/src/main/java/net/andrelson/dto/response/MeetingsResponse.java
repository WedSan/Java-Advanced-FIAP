package net.andrelson.dto.response;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public record MeetingsResponse(
        LocalDateTime meetingDate,
        Set<String> participants
) {

}
