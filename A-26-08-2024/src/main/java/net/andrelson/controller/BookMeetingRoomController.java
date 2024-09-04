package net.andrelson.controller;

import net.andrelson.dto.request.CancelReservationRequest;
import net.andrelson.dto.request.EditReservationDateRequest;
import net.andrelson.dto.request.MeetingRoomBookingRequest;
import net.andrelson.dto.response.EditReservationDateResponse;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.meeting.service.BookingManager;
import net.andrelson.meeting.model.MeetingRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("meetingRoom/book")
public class BookMeetingRoomController {

    private BookingManager bookingManager;

    public BookMeetingRoomController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    @PostMapping
    public ResponseEntity<MeetingRoomResponse> bookMeetingRoom(@RequestBody MeetingRoomBookingRequest meetingRoomBookingRequest) {

        MeetingRoom bookedMeetingRoom = bookingManager.bookMeetingRoom(meetingRoomBookingRequest.meetingDate(),
                meetingRoomBookingRequest.participantsName(),
                meetingRoomBookingRequest.meetingType());

        MeetingRoomResponse response = new MeetingRoomResponse(bookedMeetingRoom.getMeetingRoomNumber(),
                Map.of(meetingRoomBookingRequest.meetingDate(), meetingRoomBookingRequest.participantsName()),
                meetingRoomBookingRequest.meetingType());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{meetingRoomNumber}")
    public ResponseEntity<EditReservationDateResponse> editReservationDate(@PathVariable int meetingRoomNumber,
                                                                           @RequestBody EditReservationDateRequest editReservationDateRequest){

        MeetingRoom meetingRoom = bookingManager.editReservation(meetingRoomNumber,
                editReservationDateRequest.oldReservationDate(),
                editReservationDateRequest.newReservationDate());

        EditReservationDateResponse response = new EditReservationDateResponse();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{meetingRoomNumber}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int meetingRoomNumber,
                                                  @RequestBody CancelReservationRequest cancelReservationRequest) {

        bookingManager.cancelBookMeetingRoom(meetingRoomNumber, cancelReservationRequest.cancelDate());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
