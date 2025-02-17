package fiap.checkpoint.Controller;

import fiap.checkpoint.DTO.AddHotelDTO;
import fiap.checkpoint.DTO.HotelDTO;
import fiap.checkpoint.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody @Valid AddHotelDTO addHotelDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(addHotelDTO.name(),
                addHotelDTO.address()));
    }

    @GetMapping()
    public ResponseEntity<Page<HotelDTO>> listHotels(@RequestParam int page, @RequestParam int size) {

        return ResponseEntity.status(HttpStatus.OK).body(hotelService.listHotels(PageRequest.of(page, size)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
