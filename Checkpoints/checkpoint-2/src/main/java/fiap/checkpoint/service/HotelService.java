package fiap.checkpoint.service;


import fiap.checkpoint.DTO.HotelDTO;
import fiap.checkpoint.model.Hotel;
import fiap.checkpoint.model.exception.HotelStillHasRoomsException;
import fiap.checkpoint.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class HotelService {

    private final HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public HotelDTO createHotel(String hotelName, String hotelAddress) {
        Hotel hotelToBeCreated = new Hotel(hotelName, hotelAddress);
        return convertToDTO(repository.save(hotelToBeCreated));
    }

    private HotelDTO convertToDTO(Hotel hotel) {
        return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getAddress());
    }

    public Page<HotelDTO> listHotels(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::convertToDTO);
    }

    public void deleteHotel(Long id) {
        Hotel hotelFounded = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel not Found"));
        if(!hotelFounded.getRooms().isEmpty()) {
            throw new HotelStillHasRoomsException();
        }

        repository.delete(hotelFounded);

    }
}
