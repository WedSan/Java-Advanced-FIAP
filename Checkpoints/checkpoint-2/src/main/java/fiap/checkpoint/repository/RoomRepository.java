package fiap.checkpoint.repository;

import fiap.checkpoint.model.Hotel;
import fiap.checkpoint.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.type = :roomType AND r.hotel = :hotel")
    Page<Room> findAllByTypeAndHotel(@Param("roomType") String roomType, @Param("hotel") Hotel hotel, Pageable pageable);

    @Query("SELECT r FROM Room r LEFT JOIN r.reservationRooms rr " +
            "WHERE :availableDate NOT BETWEEN rr.checkInDate AND rr.checkOutDate")
    Page<Room> findRoomByAvailableDate(@Param("availableDate") LocalDate availableDate, Pageable pageable);
}
