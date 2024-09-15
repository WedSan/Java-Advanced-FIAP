package fiap.checkpoint1.service.library.reservation;

import fiap.checkpoint1.model.BookReservation;

import java.util.List;

public interface ReservationQueryFinder {

    List<BookReservation> getReservations(Long userId);
}
