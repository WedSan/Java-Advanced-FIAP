package fiap.checkpoint.service;

import fiap.checkpoint.DTO.RoomDTO;
import fiap.checkpoint.model.Hotel;
import fiap.checkpoint.model.Room;
import fiap.checkpoint.repository.HotelRepository;
import fiap.checkpoint.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    public RoomDTO createRoom(Integer number, String type, Long hotelId) {
        Hotel hotelFounded = hotelRepository.findById(hotelId).orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
        Room room = new Room(number, type, hotelFounded);
        return convertToDTO(roomRepository.save(room));
    }

    public Page<RoomDTO> getRoom(String roomType, Long hotelId, Pageable pageable) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
        Page<Room> roomList = roomRepository.findAllByTypeAndHotel(roomType, hotel, pageable);
        return roomList.map(this::convertToDTO);
    }

    public Page<RoomDTO> getRoom(LocalDate availableDate, Pageable pageable) {
        Page<Room> roomList =  roomRepository.findRoomByAvailableDate(availableDate, pageable);
        return roomList.map(this::convertToDTO);
    }

    public RoomDTO convertToDTO(Room room){
        return new RoomDTO(room.getId(), room.getNumber(), room.getType(), room.getHotel().getId());
    }
}
