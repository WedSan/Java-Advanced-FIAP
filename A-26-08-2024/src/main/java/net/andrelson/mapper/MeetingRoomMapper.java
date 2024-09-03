package net.andrelson.mapper;

import net.andrelson.dto.request.MeetingRoomCreationRequest;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.meeting.MeetingRoom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeetingRoomMapper {
    public static MeetingRoom toDomain(MeetingRoomCreationRequest dto){
        return new MeetingRoom(dto.meetingRoomNumber(), dto.meetingRoomType());
    }

    public static MeetingRoomResponse toResponse(MeetingRoom dto){
        return new MeetingRoomResponse(dto);
    }

    public static List<MeetingRoomResponse> toDtoList(List<MeetingRoom> meetingRooms){
       return meetingRooms.stream()
                .map(meetingRoom -> new MeetingRoomResponse(meetingRoom))
                .toList();
    }
}
