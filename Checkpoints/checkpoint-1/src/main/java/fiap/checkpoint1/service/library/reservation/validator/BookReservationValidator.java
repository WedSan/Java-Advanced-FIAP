package fiap.checkpoint1.service.library.reservation.validator;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface BookReservationValidator {

    void validate(List<BookReservation> reservationList, Map<Book, Queue<BookReservation>> waitingList, String bookTitle, User user);
}
