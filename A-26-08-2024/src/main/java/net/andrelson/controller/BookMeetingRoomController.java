package net.andrelson.controller;

import net.andrelson.dto.request.CancelReservationRequest;
import net.andrelson.dto.request.EditReservationDateRequest;
import net.andrelson.dto.request.MeetingRoomBookingRequest;
import net.andrelson.dto.response.EditReservationResponse;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.meeting.MeetingManager;
import net.andrelson.meeting.MeetingRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("meetingRoom/book")
public class BookMeetingRoomController {

    private MeetingManager meetingRoomManager;

    public BookMeetingRoomController(MeetingManager meetingRoomManager) {
        this.meetingRoomManager = meetingRoomManager;
    }

    @PostMapping
    public ResponseEntity<MeetingRoomResponse> bookMeetingRoom(@RequestBody MeetingRoomBookingRequest meetingRoomBookingRequest) {

        MeetingRoom bookedMeetingRoom = meetingRoomManager.bookMeetingRoom(meetingRoomBookingRequest.meetingDate(),
                meetingRoomBookingRequest.participantsName(),
                meetingRoomBookingRequest.meetingType());

        MeetingRoomResponse response = new MeetingRoomResponse(bookedMeetingRoom.getMeetingRoomNumber(),
                Map.of(meetingRoomBookingRequest.meetingDate(), meetingRoomBookingRequest.participantsName()),
                meetingRoomBookingRequest.meetingType());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{meetingRoomNumber}")
    public ResponseEntity<EditReservationResponse> editReservationDate(@PathVariable int meetingRoomNumber,
                                                                       @RequestBody EditReservationDateRequest editReservationDateRequest){
        MeetingRoom meetingRoom = meetingRoomManager.getMeetingRoom(meetingRoomNumber);

        meetingRoomManager.bookMeetingRoom(editReservationDateRequest.newReservationDate(),
                meetingRoom.getMeetings().get(editReservationDateRequest.oldReservationDate()),
                meetingRoom.getMeetingType());

        meetingRoom.removeMeeting(editReservationDateRequest.oldReservationDate());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{meetingRoomNumber}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int meetingRoomNumber,
                                                  @RequestBody CancelReservationRequest cancelReservationRequest) {

        meetingRoomManager.cancelBookMeetingRoom(meetingRoomNumber, cancelReservationRequest.cancelDate());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
