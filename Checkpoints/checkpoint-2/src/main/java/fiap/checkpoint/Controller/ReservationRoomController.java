package fiap.checkpoint.Controller;

import fiap.checkpoint.DTO.AddReservationDTO;
import fiap.checkpoint.DTO.ReservationDTO;
import fiap.checkpoint.service.ReservationRoomService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation-room")
public class ReservationRoomController {

    private ReservationRoomService reservationRoomService;

    @PostMapping //TODO: Criar objeto add dto
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody @Valid AddReservationDTO request) {
        return ResponseEntity.ok(reservationRoomService.createReservation(request.userId(),
                request.roomIds(),
                request.checkInDate(),
                request.checkOutDate()));
    }

    @GetMapping
    public ResponseEntity<Page<ReservationDTO>> getReservations(int clientId, LocalDate startDate,
                                                                LocalDate endDate,
                                                                @RequestParam int page,
                                                                @RequestParam int size) {
        return ResponseEntity.ok(reservationRoomService.getReservations(clientId, startDate, endDate, PageRequest.of(page, size)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationRoomService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
