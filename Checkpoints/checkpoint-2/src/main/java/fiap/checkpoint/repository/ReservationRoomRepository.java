package fiap.checkpoint.repository;

import aj.org.objectweb.asm.commons.Remapper;
import fiap.checkpoint.model.ReservationRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRoomRepository extends JpaRepository<ReservationRoom, Long> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
            "FROM ReservationRoom r JOIN r.rooms room " +
            "WHERE room.id = :roomId " +
            "AND ((r.checkInDate <= :checkOutDate AND r.checkOutDate >= :checkInDate))")
    boolean existsReservationRoom(@Param("roomId") Long roomId,
                                  @Param("checkInDate") LocalDate checkInDate,
                                  @Param("checkOutDate") LocalDate checkOutDate);

    @Query("SELECT r FROM ReservationRoom r JOIN r.client c " +
            "WHERE c.id = :clientId " +
            "AND r.checkInDate >= :startDate " +
            "AND r.checkOutDate <= :endDate")
    Page<ReservationRoom> findReservation(@Param("clientId") int clientId,
                                          @Param("startDate") LocalDate startDate,
                                          @Param("endDate") LocalDate endDate,
                                          Pageable pageable);
}
