package net.andrelson.controller;

import net.andrelson.dto.request.CancelReservationRequest;
import net.andrelson.dto.request.EditReservationDateRequest;
import net.andrelson.dto.request.MeetingRoomBookingRequest;
import net.andrelson.dto.response.MeetingRoomResponse;
import net.andrelson.dto.response.MeetingsResponse;
import net.andrelson.mapper.BookingMapper;
import net.andrelson.mapper.MeetingRoomMapper;
import net.andrelson.meeting.service.BookingManager;
import net.andrelson.meeting.model.MeetingRoom;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("meetingRoom/book")
public class BookMeetingRoomController {

    private BookingManager bookingManager;

    public BookMeetingRoomController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    @GetMapping("/{meetingRoomNumber}")
    public ResponseEntity<List<MeetingsResponse>> getReservations(@PathVariable("meetingRoomNumber") int meetingRomNumber) {
        Map<LocalDateTime, Set<String>> meetings = bookingManager.getMeetings(meetingRomNumber);
        List<MeetingsResponse> meetingsResponses = BookingMapper.toMeetingsResponse(meetings);
        return ResponseEntity.status(HttpStatus.OK).body(meetingsResponses);
    }

    @PostMapping
    public ResponseEntity<MeetingRoomResponse> bookMeetingRoom(@RequestBody MeetingRoomBookingRequest meetingRoomBookingRequest) {

        MeetingRoom bookedMeetingRoom = bookingManager.bookMeetingRoom(meetingRoomBookingRequest.meetingDate(),
                meetingRoomBookingRequest.participantsName(),
                meetingRoomBookingRequest.meetingType());

        MeetingRoomResponse response = MeetingRoomMapper.toResponse(bookedMeetingRoom);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{meetingRoomNumber}")
    public ResponseEntity<MeetingRoomResponse> editReservationDate(@PathVariable int meetingRoomNumber,
                                                                           @RequestBody EditReservationDateRequest editReservationDateRequest){

        MeetingRoom meetingRoom = bookingManager.editReservation(meetingRoomNumber,
                editReservationDateRequest.oldReservationDate(),
                editReservationDateRequest.newReservationDate());

        MeetingRoomResponse response = MeetingRoomMapper.toResponse(meetingRoom);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{meetingRoomNumber}")
    public ResponseEntity<Void> cancelReservation(@PathVariable int meetingRoomNumber,
                                                  @RequestBody CancelReservationRequest cancelReservationRequest) {

        bookingManager.cancelBookMeetingRoom(meetingRoomNumber, cancelReservationRequest.cancelDate());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
