package net.andrelson.mapper;

import net.andrelson.dto.response.MeetingsResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookingMapper {

    public static List<MeetingsResponse> toMeetingsResponse(Map<LocalDateTime, Set<String>> meetings){
        return meetings.entrySet()
                .stream()
                .map(localDateTimeSetEntry -> new MeetingsResponse(localDateTimeSetEntry.getKey(),
                        localDateTimeSetEntry.getValue()))
                .toList();
    }
}
