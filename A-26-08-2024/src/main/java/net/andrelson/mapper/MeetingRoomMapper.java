package net.andrelson.mapper;

import net.andrelson.dto.request.MeetingRoomCreationRequest;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.dto.response.TotalParticipantsMeetingRoom;
import net.andrelson.meeting.model.MeetingRoom;

import java.util.List;
import java.util.Map;

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


    public static List<TotalParticipantsMeetingRoom> toTotalParticipantsMeetingRoom(Map<MeetingRoom, Integer> meetingRooms){
        return meetingRooms.entrySet()
                .stream()
                .map(meetingRoomIntegerEntry -> new TotalParticipantsMeetingRoom(toResponse(meetingRoomIntegerEntry.getKey()),
                        meetingRoomIntegerEntry.getValue())).toList();
    }
}
