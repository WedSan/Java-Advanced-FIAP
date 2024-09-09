package net.andrelson.controller;

import net.andrelson.dto.request.MeetingRoomCreationRequest;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.dto.response.TotalParticipantsMeetingRoom;
import net.andrelson.mapper.MeetingRoomMapper;
import net.andrelson.meeting.service.MeetingRoomManager;
import net.andrelson.meeting.model.MeetingRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("meetingRoom")
public class MeetingRoomController {

    private MeetingRoomManager meetingRoomManager;

    public MeetingRoomController(MeetingRoomManager meetingRoomManager) {
        this.meetingRoomManager = meetingRoomManager;
    }

    @PostMapping
    public ResponseEntity<MeetingRoomResponse> addMeetingRoom(@RequestBody MeetingRoomCreationRequest meetingRoomCreationRequest) {
        MeetingRoom meetingRoom = MeetingRoomMapper.toDomain(meetingRoomCreationRequest);
        meetingRoomManager.addMeetingRoom(meetingRoom);
        MeetingRoomResponse response = MeetingRoomMapper.toResponse(meetingRoom);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MeetingRoomResponse>> getMeetingRooms() {
        List<MeetingRoom> meetingRooms = meetingRoomManager.getMeetingsRooms();
        List<MeetingRoomResponse> meetingRoomResponseList = MeetingRoomMapper.toDtoList(meetingRooms);
        return ResponseEntity.status(HttpStatus.OK).body(meetingRoomResponseList);
    }

    @GetMapping("/participants/count")
    ResponseEntity<List<TotalParticipantsMeetingRoom>> countParticipantsByMeetingRoom() {
        Map<MeetingRoom, Integer> meetingRooms = meetingRoomManager.mapTotalParticipants();
        List<TotalParticipantsMeetingRoom> totalParticipantsMeetingRoom = MeetingRoomMapper.toTotalParticipantsMeetingRoom(meetingRooms);
        return ResponseEntity.status(HttpStatus.OK).body(totalParticipantsMeetingRoom);
    }
}
