package fiap.checkpoint1.service.library;

import fiap.checkpoint1.model.Book;
import fiap.checkpoint1.model.BookReservation;
import fiap.checkpoint1.model.User;
import fiap.checkpoint1.service.library.reservation.BookReservationResult;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface LibraryManager {

    BookReservationResult reserveBook(String bookTitle, User user);

    void transferFromWaitingListToReservation(String bookTitle, int quantity);

    List<BookReservation> getAllReservations();

    List<BookReservation> getAllReservations(User user);

    Map<Book, Queue<BookReservation>> getAllWaitingList();

    List<BookReservation> getAllWaitingList(User user);

    List<BookReservation> getAllWaitingList(String bookTitle);

    void cancelReservation(String bookTitle, User user);

    void cancelWaitingList(String bookTitle, User user);
}
