package fiap.checkpoint.Controller;

import fiap.checkpoint.DTO.AddRoomDTO;
import fiap.checkpoint.DTO.RoomDTO;
import fiap.checkpoint.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@RequestBody @Valid AddRoomDTO dto){
        RoomDTO response = roomService.createRoom(dto.number(), dto.type(), dto.hotelId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/byType")
    public ResponseEntity<Page<RoomDTO>> getRooms(@RequestParam String type,
                                                  @RequestParam Long hotelId,
                                                  @RequestParam int page,
                                                  @RequestParam  int pageSize){
        Page<RoomDTO> response = roomService.getRoom(type, hotelId, PageRequest.of(page, pageSize));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/byDate")
    public ResponseEntity<Page<RoomDTO>> getRooms(@RequestParam LocalDate availableDate,
                                                  @RequestParam int page,
                                                  @RequestParam int pageSize){
        Page<RoomDTO> response = roomService.getRoom(availableDate, PageRequest.of(page, pageSize));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
