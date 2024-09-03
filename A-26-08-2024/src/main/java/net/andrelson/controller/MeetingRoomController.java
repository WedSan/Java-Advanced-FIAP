package net.andrelson.controller;

import net.andrelson.dto.request.MeetingRoomCreationRequest;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.mapper.MeetingRoomMapper;
import net.andrelson.meeting.MeetingManager;
import net.andrelson.meeting.MeetingRoom;
import net.andrelson.meeting.exception.MeetingRoomAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meetingRoom")
public class MeetingRoomController {

    private MeetingManager meetingRoomManager;

    public MeetingRoomController(MeetingManager meetingRoomManager) {
        this.meetingRoomManager = meetingRoomManager;
    }

    @PostMapping
    public ResponseEntity<String> addMeetingRoom(@RequestBody MeetingRoomCreationRequest meetingRoomCreationRequest) {
        MeetingRoom meetingRoom = MeetingRoomMapper.toDomain(meetingRoomCreationRequest);
        meetingRoomManager.addMeetingRoom(meetingRoom);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<MeetingRoomResponse>> getMeetingRooms() {
        List<MeetingRoom> meetingRooms = meetingRoomManager.getMeetingsRooms();
        List<MeetingRoomResponse> meetingRoomResponseList = MeetingRoomMapper.toDtoList(meetingRooms);
        return ResponseEntity.status(HttpStatus.OK).body(meetingRoomResponseList);
    }
}
