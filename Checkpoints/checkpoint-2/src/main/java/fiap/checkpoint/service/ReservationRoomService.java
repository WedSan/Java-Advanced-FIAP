package fiap.checkpoint.service;

import fiap.checkpoint.DTO.ReservationDTO;
import fiap.checkpoint.model.Client;
import fiap.checkpoint.model.ReservationRoom;
import fiap.checkpoint.model.Room;
import fiap.checkpoint.model.exception.RoomAlreadyReservedException;
import fiap.checkpoint.repository.ClientRepository;
import fiap.checkpoint.repository.ReservationRoomRepository;
import fiap.checkpoint.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationRoomService {

    private ReservationRoomRepository repository;

    private RoomRepository roomRepository;

    private ClientRepository clientRepository;

    public ReservationDTO createReservation(Long userId, List<Long> roomsId, LocalDate checkInDate, LocalDate checkOutDate) {
        Client client = clientRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Client not found"));

        List<Room> roomsReserved = new ArrayList<>();
        roomsId.forEach(roomId -> {
            if(repository.existsReservationRoom(roomId, checkInDate, checkOutDate)) {
                throw new RoomAlreadyReservedException("Room already reserved");
            }
            Room roomFounded = roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Room not found"));
            roomsReserved.add(roomFounded);
        });

        ReservationRoom reservation = new ReservationRoom(checkInDate, checkOutDate, client, roomsReserved);
        return convertToDTO(repository.save(reservation));
    }

    public Page<ReservationDTO> getReservations(Pageable pageable) {
        return repository.findAll(pageable).map(this::convertToDTO);
    }

    public Page<ReservationDTO> getReservations(int clientId, LocalDate startDate,
                                                LocalDate endDate, Pageable pageable) {
        return repository.findReservation(clientId, startDate, endDate, pageable).map(this::convertToDTO);
    }

    public ReservationDTO convertToDTO(ReservationRoom reservation) {
        return new ReservationDTO(reservation.getId(),
                reservation.getCliente().getId(),
                reservation.getRooms().stream().map(Room::getId).toList(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate());
    }

    public void deleteReservation(Long id) {
        repository.deleteById(id);
    }
}
